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
        case "Formation de formateurs ou du Personnel administratif ou technique":
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
        case "Publications dans des revues indexées dans les bases internationales  comme: SCOPUS, THOMPSON":
          endpoint = "http://localhost:9005/api/add-publications-revues-indexées";
          break;
        case "Publications dans des revues scientifiques nationales ou internationales à comité de lecture ISSN (tel qu'il est défini  dans la liste officielle du CNRST)":
          endpoint = "http://localhost:9005/api/add-publication-revues-scientifiques";
          break;
        case "Ouvrage spécialisé ISBN":
          endpoint = "http://localhost:9005/api/add-ouvrage-specialisé";
          break;
        case "Chapitre d'un ouvrage collectif publié par une maison d'édition ISBN":
          endpoint = "http://localhost:9005/api/add-chapitre-ouvrage";
          break;
        case "Congrès ou conférence":
          endpoint = "http://localhost:9005/api/add-congrès-conférences-publiées";
          break;
        case "Communications dans des congrès ou des conférences (non publiés)":
          endpoint = "http://localhost:9005/api/add-congrès-conférences-non-publiées";
          break;
        case "Doctorats encadrés":
          endpoint = "http://localhsot:9005/api/add-doctorats-encadrés";
          break;
        case "Encadrement des mémoires de Master":
          endpoint = "http://localhost:9005/api/add-encadrement-mémoires-master";
          break;
        case "Participaction à thèse doctorat ou d'habilitation":
          endpoint = "http://localhost:9005/api/add-participation-thèse-doctorat";
          break;
        case "Responsable ou membre d'une structure de recherche accréditée ou d'un pole de compétence(cumulable)":
          endpoint = "http://localhost:9005/api/add-responsable-membre-structure-recherche-accréditée-pole-competence";
          break;
        case "Association pour la connaissance":
          endpoint = "http://localhost:9005/api/add-association-connaissance";
          break;
        case "Projets ou contrats de recherche au niveau national ou international ou les deux":
          endpoint = "http://localhost:9005/api/add-projets-contrats-recherche";
          break;
        case "Editeur, membre ou référé d'un journal ou revue scientifique":
          endpoint = "http://localhost:9005/api/add-editeur-membre-référé-journal-revue";
          break;
        case "Expertise non rémunérée de projet de recherche scientifique":
          endpoint = "http://localhost:9005/api/add-expertise-non-rémunéré";
          break;
        case "Contribution à l'organisation d'activités de rayonnement de l'établissement (séminaires, congrès, colloque, ateliers, formation continue, ou autre)":
          endpoint = "http://localhost:9005/api/add-contribution-organisation-activités-rayonnement";
          break;
        case "Projet de recherche et de développement avec le secteur privé":
          endpoint = "http://localhost:9005/api/add-projet-de-recherche-developpement";
          break;
        case "Brevet":
          endpoint = "http://localhost:9005/api/add-brevet";
          break;
        case "Incubation de projet de recherche et de développement":
          endpoint = "http://localhost:9005/api/add-incubation-projet-recherche";
          break;
        case "Création de start up":
          endpoint = "http://localhost:9005/api/add-création-startup";
          break;
        
    }
    return endpoint;
}

export default getEndpoint;