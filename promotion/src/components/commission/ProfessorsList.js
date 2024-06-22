import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { 
    Table,
    TableBody,
    TableCell,
    TableContainer,
    TableHead,
    TableRow,
    Paper,
    Avatar,
    Grid,
    Typography,
    TablePagination,
    TableFooter,
    makeStyles
} from '@material-ui/core';
import { useNavigate } from 'react-router-dom';

const useStyles = makeStyles((theme) => ({
    table: {
        minWidth: 650,
    },
    tableContainer: {
        borderRadius: 15,
        margin: '10px 10px',
        maxWidth: 950
    },
    tableHeaderCell: {
        fontWeight: 'bold',
        backgroundColor: '#A66253',
        color: theme.palette.getContrastText(theme.palette.primary.dark)
    },
    avatar: {
        backgroundColor: '#B2B2B2',
        color: theme.palette.getContrastText(theme.palette.primary.light)
    },
    name: {
        fontWeight: 'bold',
        color: '#0D0D0D'
    },
    status: {
        fontWeight: 'bold',
        fontSize: '0.75rem',
        color: 'white',
        backgroundColor: 'grey',
        borderRadius: 8,
        padding: '3px 10px',
        display: 'inline-block'
    }
}));

function ProfessorsList() {
    const classes = useStyles();
    const navigate = useNavigate();
    const [data, setData] = useState([]);
    const [page, setPage] = useState(0);
    const [rowsPerPage, setRowsPerPage] = useState(5);

    useEffect(() => {
        axios.get('http://localhost:9005/admincommission/get-professors',
            {
                headers: {
                    'Authorization': 'Bearer ' + localStorage.getItem('token'),
                  },
            }
        ) 
            .then(response => {
                setData(response.data);
            })
            .catch(error => {
                console.error("Erreur lors de la récupération des données des professeurs :", error);
            });
    }, []);

    const handleChangePage = (event, newPage) => {
        setPage(newPage);
    };

    const handleChangeRowsPerPage = (event) => {
        setRowsPerPage(+event.target.value);
        setPage(0);
    };

    const handleRowClick = (row) => {
        console.log(row);
        navigate('/selected-user-activities', {state: {prof: row}}); 
    };
   // console.log(data);

    return (
        <TableContainer component={Paper} className={classes.tableContainer}>
            <Table className={classes.table} aria-label="simple table">
                <TableHead>
                    <TableRow>
                        <TableCell className={classes.tableHeaderCell}>Professeur</TableCell>
                        <TableCell className={classes.tableHeaderCell}>Profile</TableCell>
                        <TableCell className={classes.tableHeaderCell}>Statut d'évaluation</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {data.slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage).map((row, index) => (
                        <TableRow key={index} onClick={() => handleRowClick(row)}>
                            <TableCell>
                                <Grid container alignItems="center">
                                    <Grid item lg={2}>
                                        <Avatar alt={`${row.firstname} ${row.lastname}`} src='.' className={classes.avatar}/>
                                    </Grid>
                                    <Grid item lg={10} style={{ paddingLeft: '10px' }}>
                                        <Typography className={classes.name}>{`${row.firstname} ${row.lastname}`}</Typography>
                                        <Typography color="textSecondary" variant="body2">{row.email}</Typography>
                                        <Typography color="textSecondary" variant="body2">{row.phone}</Typography>
                                    </Grid>
                                </Grid>
                            </TableCell>
                            <TableCell>
                                <Typography color="textPrimary" variant="subtitle2">{row.profile}</Typography>
                                <Typography color="textSecondary" variant="body2">{row.establishment}</Typography>
                            </TableCell>
                            <TableCell>
                                <Typography
                                    className={classes.status}
                                    style={{
                                        backgroundColor:
                                            (row.evaluationStatus === 'Evaluated' && 'green') ||
                                            (row.evaluationStatus === 'Pending' && 'blue') ||
                                            (row.evaluationStatus === 'Not Evaluated' && 'orange')
                                    }}
                                >{row.evaluationStatus}</Typography>
                            </TableCell>
                        </TableRow>
                    ))}
                </TableBody>
                <TableFooter>
                    <TableRow>
                        <TablePagination
                            rowsPerPageOptions={[5, 10, 15]}
                            component="div"
                            count={data.length}
                            rowsPerPage={rowsPerPage}
                            page={page}
                            onPageChange={handleChangePage}
                            onRowsPerPageChange={handleChangeRowsPerPage}
                        />
                    </TableRow>
                </TableFooter>
            </Table>
        </TableContainer>
    );
}

export default ProfessorsList;