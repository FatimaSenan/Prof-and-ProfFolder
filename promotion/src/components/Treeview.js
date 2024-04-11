import * as React from 'react';
import { styled } from '@mui/material/styles';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import { SimpleTreeView } from '@mui/x-tree-view/SimpleTreeView';
import { TreeItem, treeItemClasses } from '@mui/x-tree-view/TreeItem';
import Collapse from '@mui/material/Collapse';
import { animated, useSpring } from '@react-spring/web';
import { FaChalkboardTeacher } from "react-icons/fa";
import { GiArchiveResearch } from "react-icons/gi";
import { IoIosAddCircle } from "react-icons/io";





const StyledTreeItemLabel = styled(Typography)({
  color: '#2C6975',
  fontFamily: 'General Sans',
  fontWeight: 'inherit',
  flexGrow: 1,
  fontSize: '1.1rem',
});

const StyledTreeItemRoot = styled(TreeItem)(({ theme }) => ({
  color:
    theme.palette.mode === 'light'
      ? theme.palette.grey[800]
      : theme.palette.grey[400],
  position: 'relative',
  [`& .${treeItemClasses.content}`]: {
    flexDirection: 'row-reverse',
    borderRadius: theme.spacing(0.7),
    marginBottom: theme.spacing(0.5),
    marginTop: theme.spacing(0.5),
    padding: theme.spacing(0.5),
    paddingRight: theme.spacing(1),
    fontWeight: 800,
    [`& .${treeItemClasses.label}`]: {
      fontWeight: 'inherit',
    },
    [`& .${treeItemClasses.iconContainer}`]: {
      marginRight: theme.spacing(2),
    },
    [`&.Mui-expanded `]: {
      '&:not(.Mui-focused, .Mui-selected, .Mui-selected.Mui-focused) .labelIcon': {
        color:
          "#2C6975"
      },
      '&::before': {
        content: '""',
        display: 'block',
        position: 'absolute',
        left: '16px',
        top: '44px',
        height: 'calc(100% - 48px)',
        width: '1.5px',
        backgroundColor:
          theme.palette.mode === 'light'
            ? theme.palette.grey[300]
            : theme.palette.grey[700],
      },
    },
    '&:hover': {
      backgroundColor: "#E0ECDE",
      color: theme.palette.mode === 'light' ? theme.palette.primary.main : 'white',
    },
    [`&.Mui-focused, &.Mui-selected, &.Mui-selected.Mui-focused`]: {
      backgroundColor:
        "#68b2a0",
      color: 'white',
    },
  },
  [`& .${treeItemClasses.groupTransition}`]: {
    marginLeft: theme.spacing(3.5),
    [`& .${treeItemClasses.content}`]: {
      fontWeight: 500,
    },
  },
}));

const AnimatedCollapse = animated(Collapse);

function TransitionComponent(props) {
  const style = useSpring({
    to: {
      opacity: props.in ? 1 : 0,
      transform: `translate3d(0,${props.in ? 0 : 20}px,0)`,
    },
  });

  return <AnimatedCollapse style={style} {...props} />;
}

const StyledTreeItem = React.forwardRef(function StyledTreeItem(props, ref) {
  const { labelIcon: LabelIcon, labelText, ...other } = props;

  return (
    <StyledTreeItemRoot
      slots={{
        groupTransition: TransitionComponent,
      }}
      label={
        <Box
          sx={{
            display: 'flex',
            alignItems: 'center',
          }}
        >
          <Box
            component={LabelIcon}
            className="labelIcon"
            color="#2C6975"
            sx={{ mr: 1, fontSize: '1.4rem' }}
          />
          <StyledTreeItemLabel variant="body2">{labelText}</StyledTreeItemLabel>
        </Box>
      }
      {...other}
      ref={ref}
    />
  );
});

export default function TreeView() {
  return (
    <SimpleTreeView
      aria-label="gmail"
      fontSize="80"
      defaultExpandedItems={['3']}
      defaultSelectedItems="3"
      sx={{ height: 'fit-content', flexGrow: 1, maxWidth: 800, overflowY: 'auto' }}
    >
      <StyledTreeItem itemId="1" labelText="Activités d'enseignement" labelIcon={FaChalkboardTeacher}>
        <StyledTreeItem itemId="1.1" labelText="Les activités pédagogiques">
          <StyledTreeItem itemId="1.1.1" labelText=" Publication d'ouvrages en relation avec le domaine de l'enseignement">
            <StyledTreeItem itemId="A11" labelText=" Ouvrage pédagogique et/ou didactique (ISBN ou  Maison d'édition)" labelIcon={IoIosAddCircle} />
            <StyledTreeItem itemId="A12" labelText="Manuel ( exercices corrigés, annales examens corrigés, etc.) (ISBN, ou validé par le chef d'établissement)" labelIcon={IoIosAddCircle} />
          </StyledTreeItem >
        </StyledTreeItem>
      </StyledTreeItem>
      <StyledTreeItem itemId="2" labelText="Activités de recherche" labelIcon={GiArchiveResearch}>
        <StyledTreeItem itemId="2.1" labelText="La production scientifique">
            <StyledTreeItem itemId="2.1.1" labelText=" Articles scientifiques publiés dans des revues indexées internationales, ou des actes de congrès internationaux ou nationaux ou à comité de lecture internationaux ou nationaux">
                   
                <StyledTreeItem itemId="B.1" labelText="Publications dans des revues indexées dans les bases internationales comme: SCOPUS, THOMPSON">
                   <StyledTreeItem itemId="B11" labelText=" Niveau 1: Impact factor<1" labelIcon={IoIosAddCircle} />
                   <StyledTreeItem itemId="B12" labelText="Niveau 2: Impact factor de 1 à <5" labelIcon={IoIosAddCircle} />
                </StyledTreeItem>
            </StyledTreeItem >
          </StyledTreeItem>
        </StyledTreeItem>
    </SimpleTreeView>
  );
}