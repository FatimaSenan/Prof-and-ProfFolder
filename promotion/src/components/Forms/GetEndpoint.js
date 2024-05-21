const getEndpoint = (selectedActivity) => {
    let endpoint = '';
    switch (selectedActivity) {
       
        case "Chef de département":
          endpoint = "http://localhost:9005/api/add-chef-departement";
          break;
        case "Coordonnateur d'une filière":
          endpoint = "http://localhost:9005/api/add-coordonateur-filière";
          break;
        case "Coordonnateur d'un module (ou deux au maximum )":
          endpoint = "http://localhost:9005/api/add-coordonateur-module";
          break;
        case "Didacticiels":
          endpoint = "http://localhost:9005/api/add-didacticiels";
          break;
        case "Mémoire de PFE":
          endpoint = "http://localhost:9005/api/add-encadrement-pfe";
          break;
        case "Encadrement des ressources humaines":
          endpoint = "http://localhost:9005/api/add-encadrement-RH";
          break;
        case "Manuel ( exercices corrigés, annales examens corrigés, etc.) (ISBN, ou validé par le chef d'établissement)":
          endpoint = "http://localhost:9005/api/add-manuel";
          break;
        case "Membre d'une commission ad hoc":
          endpoint = "http://localhost:9005/api/add-membre-commission-adhoc";
          break;
        case "Membre d'une commission permanente du conseil de coordination":
          endpoint = "http://localhost:9005/api/add-membre-commission-conseil";
          break;
        case "Membre d'une commission permanente de l'établissement":
          endpoint = "http://localhost:9005/api/add-membre-commission-etablissement";
          break;
        case "Membre du conseil de coordination":
          endpoint = "http://localhost:9005/api/add-membre-conseil-coordination";
          break;
        case "Membre élu du conseil d'établissement":
          endpoint = "http://localhost:9005/api/add-membre-elu-conseil";
          break;
        case "Montages expérimentaux":
          endpoint = "http://localhost:9005/api/add-montages-expérimentaux";
          break;
        case "MOOC : Production de contenus en ligne":
          endpoint = "http://localhost:9005/api/add-mooc";
          break;
        case "Ouvrage pédagogique et/ou didactique (ISBN ou  Maison d'édition)":
          endpoint = "http://localhost:9005/api/add-ouvrage";
          break;
        case "Page web à caractère pédagogique":
          endpoint = "http://localhost:9005/api/add-page-web";
          break;
        case "Petits livres de méthodologie ou de didactique pour la lecture ou l'analyse":
          endpoint = "http://localhost:9005/api/add-petit-livre";
          break;
        case "Polycopiés pédagogiques":
          endpoint = "http://localhost:9005/api/add-polycopié-pédagogique";
          break;
        case "Préparation de sorties de terrain":
          endpoint = "http://localhost:9005/api/add-préparation-sorties-terrain";
          break;
        case "Rapport de stage de visite ou de terrain":
          endpoint = "http://localhost:9005/api/add-rapport-stage-visite-terrain";
          break;
        case "Supports":
          endpoint = "http://localhost:9005/api/add-support";
          break;
        case "Vice-doyen ( non cumulable avec commission permanente)":
          endpoint = "http://localhost:9005/api/add-vice-doyen";
          break;
    }
    return endpoint;
}

export default getEndpoint;