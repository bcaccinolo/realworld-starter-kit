# Source
https://github.com/bcaccinolo/realworld-starter-kit

# Todo

- ✅ {{APIURL}}/tags
    - ✅ creation des entités 
    - ✅ création de la DB
    - ✅ création du service pour get les articles
        - méthode pour créer une liste de random tags à partir d'une liste
        - retourne la liste de tous les tags (findAll)
    - ✅ creation du controller
        - the endpoint returns an object with a key 'tags'
  
- ✅ {{APIURL}}/articles
    - ✅ creation des entités et repository
    - ✅ création de données de tests
        - get the content of Json file 
        - deserialize one article in JSON format with Jackson
        - deserialize an article list with Jackson
    - ✅ créaction du controller
    - ✅ ajout timestamp dans modèle
    - ✅ ajout updatedDate

- ✅ {{APIURL}}/articles - Profile associations
    - ✅ author associations > @ManyToOne
    - ✅ serialize the association Article.Profile : automatic     

- ✅ {{APIURL}}/articles - Tags list associations
    - ✅ associate some tags to Article - ManyToMany  
    - ✅ serialize `Article.tags` as an array of String

- aggrandir la taille du champs 'body' > TEXT    

## Notes

## DB commands
Let's get a db
`
docker pull mysql:8
`

### set db settings

All the db env variables are stored in a `.env` file.

### Let's run the db
`
docker run --rm --name $DB_CONTAINER_NAME -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=$DB_NAME mysql:8
`

### Get ip to connect

Once the container is started, the `.env` file exports the IP of the container in `DB_IP`

### Stop the db container
`
d container stop $DB_CONTAINER_NAME
`

### Connect to the db
`
 mycli -u root -p root -h $DB_IP $DB_NAME
`

### Fill the db 
`
mycli -u root -p root -h $DB_IP $DB_NAME < init.sql
`



