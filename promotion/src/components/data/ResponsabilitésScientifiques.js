
const ResponsabilitésScientifique = [
    {
        "type": "Responsable ou membre d'une structure de recherche (au moins une année) ",
        "activités": [
            {"activité": "Responsable ou membre d'une structure de recherche accréditée",
             "informations": ["Résponsabilité", "année de début", "année de fin"]
            },
            {"activité": "Pole de compétence (cumulable)",
             "informations": ["Résponsabilité", "année de début", "année de fin"]
            },
            {"activité": "Association pour la connaissance",
             "informations": ["Résponsabilité", "année de début", "année de fin"]
            }
            
        ]
    },
    {
        "type": "Projets ou contrats de recherche (Attestation délivrée par le chef d'établissement)",
        "activités": [
            {
                "activité": "Projets ou contrats de recherche au niveau national ou international ou les deux",
                "informations": ["titre de projet", "responsabilité", "cadre de projet", "type","année de début", "année de fin"]
            }
        ]
    },
    {
        "type": "Les activités d'expertises et d'évaluations scientifiques nationales et internationales (correctement justifiée par une attestation ou un rapport signé par le chef d'établissement) ",
        "activités": [
            {
                "activité": "éditeur, membre ou référé d'un journal ou revue scientifique",
                "informations": ["journal/revue", "ISBN/ISSN", "role", "année"]
            },
            {
                "activité": "expertise non rémunérée de projet de recherche scientifique",
                "informations": ["projet", "nature", "année"]
            }
        ]
    }
]
export default ResponsabilitésScientifique;