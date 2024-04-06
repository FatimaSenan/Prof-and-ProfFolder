import React,{useState} from "react";
import MatereialTable from 'material-table';


function Tablecomission() {
  const [tableData,setTableData] =useState([{enseignant:"NOM Prènom 1",email:"n.prenom@ump.ac.ma",etat:"évalué"},
  {enseignant:"NOM Prènom 2",email:"n.prenom@ump.ac.ma",etat:"non évalué"}

]);
  const columns=[
    {title:"Enseignant",field:"enseignant"},
    {title:"Email",field:"email"},
    {title:"Etat d'évaluation",field:"etat"}
    
  ]
  return (
    <>
      
      <MatereialTable columns={columns} data={tableData} title=""  />
    </>
    
  )
}

export default Tablecomission;