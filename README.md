# TASK

A job is a collection of tasks, where each task has a name and a shell command. Tasks may
depend on other tasks and require that those are executed beforehand. The service takes care
of sorting the tasks to create a proper execution order.
Here’s an example request body:
```json
{
   "tasks":[
      {
         "name":"task-1",
         "command":"touch /tmp/file1"
      },
      {
         "name":"task-2",
         "command":"cat /tmp/file1",
         "requires":[
            "task-3"
         ]
      },
      {
         "name":"task-3",
         "command":"echo 'Hello World!' > /tmp/file1",
         "requires":[
            "task-1"
         ]
      },
      {
         "name":"task-4",
         "command":"rm /tmp/file1",
         "requires":[
            "task-2",
            "task-3"
         ]
      }
   ]
}
```
For which an example response might look like the following:
```json
[
   {
      "name":"task-1",
      "command":"touch /tmp/file1"
   },
   {
      "name":"task-3",
      "command":"echo 'Hello World!' > /tmp/file1"
   },
   {
      "name":"task-2",
      "command":"cat /tmp/file1"
   },
   {
      "name":"task-4",
      "command":"rm /tmp/file1"
   }
]
```
Additionally, the service should be able to return a bash script representation directly:
```shell script
#!/usr/bin/env bash
touch /tmp/file1
echo "Hello World!" > /tmp/file1
cat /tmp/file1
rm /tmp/file1
```
Thus allowing us to run the commands directly from shell, for example:
```shell script
$ curl -d @mytasks.json http://localhost:4000/... | bash
```

# How to test
To obtain JSON response
```shell script
curl -H "Content-Type: application/json" \
     -X POST -d @mytask.json \
     localhost:4000/api/tasks
```
To obtain bash script response:
```shell script
curl -H "Content-Type: application/json" \
     -H "x-api-version: 2" \
     -X POST -d @mytask.json \
     localhost:4000/api/tasks
```

### Technologies

* Maven (v3.6.3)
* Spring Boot (v2.3.0)

### Guides
The following manuals and references were used during implementation:

* [Topological sorting for sorting task](https://en.wikipedia.org/wiki/Topological_sorting)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)