# java-spring-users

## PROJECTS
### GET PROJECTS
GET: 			{Host}:{Port}/api/v1/projects
GET: 			{Host}:{Port}/api/v1/projects/{project_id}
GET EXAMPLE:	10.31.35.100:8080/api/v1/projects
GET EXAMPLE:	10.31.35.100:8080/api/v1/projects/{project_id}

### POST PROJECTS

POST:			{Host}:{Port}/api/v1/projects

POST EXAMPLE:	10.31.35.100:8080/api/v1/projects

BODY:
{
    "id": "1",
    "name": "MyProject001"
}

### PUT PROJECTS
PUT:			{Host}:{Port}/api/v1/projects/{project_id}

PUT EXAMPLE:	10.31.35.100:8080/api/v1/projects/1

BODY:
{
    "id": "1",
    "name": "MyProject001"
}

### DELETE PROJECTS
DELETE: 			{Host}:{Port}/api/v1/projects/{project_id}

DELETE EXAMPLE:		10.31.35.100:8080/api/v1/projects/1
