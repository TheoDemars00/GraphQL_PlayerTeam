# This project is a scholar project to use GraphQL API

The goal of this project was to develop a GraphQL API. This API had to handle teams and players.  *For now there is no Node Js client to use the API. Sorry, but it might come later.* 

However you can use the folowing steps to test the API. 

**Thanks !**

## This is how you should use it
1. Clone this project on your computer
2. Open it in you favorite Java IDE
3. Launch the project
4. Open the page : http://localhost:8080/graphiql
5. You can just copy paste the folowing lines into the left part of the tool :

query MyQuery {
   getTeams{
	id
  team_name
  city
  }

  getPlayers{
    id
    first_name
    last_name
    date_of_birth
    height
  }
  
}

mutation MyMutation{
  
updatePlayer(id:"0",first_name:"Jonh",last_name:"Doe",date_of_birth : "29/02/1902", height:"210"){
  	id
  	first_name
  	last_name
  	date_of_birth
  	height
	}
   
 updateTeam(id:"0",team_name:"ASSE",city:"Saint-Etienne"){
  id
  team_name
  city
	}
  
  deleteTeam(id:"4"){
    id
  }
  
  deletePlayer(id:"4"){
    id
  }
  
}

6. Click the execute query button :
   - Execute query, observe the result
   - Execute Mutations
   - Execute query, observe the changes


