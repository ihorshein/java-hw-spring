## Testing

1. Create a Todo (valid; only required fields):

    ```shell
    curl --location 'http://localhost:8080/todos' \
    --header 'Content-Type: application/json' \
    --data '{
        "title": "Wash the windows",
        "dueDate": "2025-01-01T10:25:00"
    }' 
    ```

2. Create a Todo (valid; all fields):

    ```shell
    curl --location --request POST 'http://localhost:8080/todos' \
    --header 'Content-Type: application/json' \
    --data '{
        "title": "Read the book",
        "description": "Very interesting book",
        "dueDate": "2025-06-01T11:00:00",
        "priority": "LOW",
    }' 
    ```

3. Update a Todo:

    ```shell
    curl --location --request PUT 'http://localhost:8080/todos/1' \
    --header 'Content-Type: application/json' \
    --data '{
        "title": "Wash the front windows",
        "description": "Wash only the front windows",
        "dueDate": "2025-01-10T00:00:10",
        "priority": "MEDIUM",
        "status": "PENDING"
   }'
   ```

4. Delete a Todo:

   ```shell
   curl --location --request DELETE 'http://localhost:8080/todos/2'
   ```

5. View Task History:
    
   ```shell
   curl --location 'http://localhost:8080/todos/1/history'
   ```

6. Validation example (priority field fail):
    
   ```shell
    curl --location 'http://localhost:8080/todos' \
    --header 'Content-Type: application/json' \
    --data '{
        "title": "Read the book",
        "dueDate": "2021-06-01T00:00:00",
        "priority": "NX"
    }' 
    ```