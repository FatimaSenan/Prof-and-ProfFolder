export const rechercheTypes = [
    {
      name: 'La production scientifique',
      subTypes: [
        { 
          name: 'Articles scientifiques publiés dans des revues indexées internationales, ou des actes de congrès internationaux ou nationaux ou à comité de lecture internationaux ou nationaux',
          activities: [
            { name: "Publications dans des revues indexées dans les bases internationales  comme: SCOPUS, THOMPSON" },
            { name: "Publications dans des revues scientifiques nationales ou internationales à comité de lecture ISSN (tel qu'il est défini  dans la liste officielle du CNRST)"}
          ]
        },
        { 
          name: 'Ouvrages de recherche',
          activities: [
            { name: "Ouvrage spécialisé ISBN et publié par une maison d'édition" },
            { name: "Chapitre d'un ouvrage collectif publié par une maison d'édition ISBN" }
          ]
        },
        { 
            name: 'Communications dans des congrès ou des conférences (rédigées et publiées dans le Proceeding)(Les communications ne peuvent être comptabilisées qu\'une seule fois)',
            activities: [
              { name: "Congrès ou conférence" }
            ]
        },
        { 
            name: 'Communications dans des congrès ou des conférences (non publiés) (Les communications ne peuvent être comptabilisées qu\'une seule fois)',
            activities: [
              { name: "Communications dans des congrès ou des conférences (non publiés)" }
            ]
        }
      ]
    },
    {
      name:  " L'encadrement scientifique" ,
      subTypes: [
        { 
          name: 'Encadrement des thèses de doctorat (Attest,ation délivrée par le chef d\'établissement)',
          activities: [
            { name: 'Doctorats encadrés' }
          ]
        },
        { 
          name: 'Encadrement des mémoires de Master (Attestation délivrée par le chef d\'établissement',
          activities: [
            { name: 'Encadrement des mémoires de Master' }
          ]
        },
        { 
            name: 'Participation comme président ou rapporteur ou membre du jury de thèse de doctorat ou d\'habilitation (Attestation délivrée par le chef d\'établissement)',
            activities: [
              { name: 'Participaction à thèse doctorat ou d\'habilitation' }
            ]
          }
      ]
    },
    {
        name:  "Les responsabilités scientifiques" ,
        subTypes: [
          { 
            name: 'Responsable ou membre d\'une structure de recherche (au moins une année)',
            activities: [
              { name: 'Responsable ou membre d\'une structure de recherche accréditée ou d\'un pole de compétence(cumulable)' },
              { name: 'Association pour la connaissance' }
            ]
          },
          { 
            name: 'Projets ou contrats de recherche (Attestation délivrée par le chef d\'établissement)',
            activities: [
              { name: 'Projets ou contrats de recherche au niveau national ou international ou les deux' }
            ]
          },
          { 
              name: 'Les activités d\'expertises et d\'évaluations scientifiques nationales et internationales (correctement justifiée par une attestation ou un rapport signé par le chef d\'établissement) ',
              activities: [
                { name: 'Editeur, membre ou référé d\'un journal ou revue scientifique' },
                { name: 'Expertise non rémunérée de projet de recherche scientifique' }
              ]
            }
        ]
      },
      {
        name:  "Rayonnement-Ouverture-Innovation-Valorisation" ,
        subTypes: [
          { 
            name: 'Animation des structures d\'interaction avec l\'environnement socio-économique et organisation des manifestations scientifiques (le nom du candidat organisateur doit figurer sur le dépliant correspondant, à fournir)',
            activities: [
              { name: 'Contribution à l\'organisation d\'activités de rayonnement de l\'établissement (séminaires, congrès, colloque, ateliers, formation continue, ou autre)' }            ]
          },
          { 
            name: 'Expertise et valorisation d\'actions au profit des milieux socio-économiques (correctement justifiée par une attestation ou un rapport d\'expertise signé et cacheté par le chef d\'établissement)',
            activities: [
              { name: 'Projet de recherche et de développement avec le secteur privé' },
              { name: 'Brevet' },
              {name: 'Incubation de projet de recherche et de développement'},
              {name: 'Création de start up'}
            ]
          }
        ]
      }
  ];