# Advanced Java with Spring
## Web Application 'ToDo List'

## 📋 Project Overview
This is a Spring MVC web application for managing ToDo lists with tasks. The project implements a complete CRUD functionality for Users, ToDo lists, Tasks, and States.

## 🎯 Student Task
Implement the **UserController** and **ToDoController** methods marked with `// TODO` comments. All other components (models, repositories, services, State and Task controllers) are already implemented.

### Create Web Application with:

    1. 'User' page for displaying information about all registered users
    2. 'Update existing user' for updating a user
    3. 'Create New User' page for creating a new user
    4. 'All ToDo lists of <user>' page with showing information about all ToDo lists of some user and adding new ToDo list
    5. 'Update ToDo list' for updating an existing ToDo list
    6. 'Create New ToDo list' page for creating a new ToDo list of some user
    7. 'All Tasks of ToDo list' page where user can see all tasks from some ToDo list and add a new task
    8. 'Create New Task' for creating a new task for some ToDo list of concrete user
    9. 'Update Task' page some existing task

### 'Home' page
'Home' page should contain image with some text (see mockup).

### Menu
    1. Menu should be present on all pages
    2. When the user clicks on the 'ToDos Lists' logo or `Home` word on any page 'Home' page should be opened

### 'User' page
'User' page should contain information about all registered users.

    1. There should be a menu and a table with information about all registered users
    2. When a user clicks on ‘Edit’ link near some user 'Update Existing User' page with filled data 
about the selected user should be opened

3. When a user clicks on ‘Remove’ link the corresponding user should be deleted
4. When a user clicks on the 'Create New User' button 'Create New User' page with empty fields should be opened
5. When the user clicks on the name of some user All ToDo lists of <user> should be opened


### 'Update Existing User' page
‘Update existing User’ page should contain filled form with information about the selected user and 'Update' and 'Clear' buttons

    1. When a user clicks on ‘Clear’ button all fields should be cleared
    2. When the user clicks on 'Update’ button' changed data should be saved and 'Home' page should be opened 

### ‘Create New User’ page
‘Create new User’ page should contain a form for creating a new user and 'Register' and 'Clear' buttons

    1. When a user clicks on ‘Clear’ button all fields should be cleared
    2. When the user clicks on 'Register’ button' all entered data should be saved and 'All ToDo Lists of <user>' page should be opened 

### 'All ToDo lists of <user>' page
'All ToDo lists of <user>' page should contain a table with information about all ToDo list some user and 'Create New ToDo list' button

    1. When a user clicks on ‘Edit’ link near some list 'Update ToDo list' page with filled data about the selected list should be opened
    2. When a user clicks on ‘Remove’ link the corresponding list should be deleted
    3. When a user clicks on the 'Create New ToDo list' button 'Create New ToDo List' page with empty fields should be opened
    4. When the user clicks on the name of some list 'All Tasks of <ToDo Lists>' should be opened

### 'All Tasks From <User's ToDo List>'
'All Tasks From <User's ToDo List> should contain 'Create Tasks' button, 'Tasks' table, dropdown for adding collaborators, list all collaborators, and 'Go to ToDo Lists' link

### 'Create New Task' page
'Create New Task' page should contain 'Name' fields, "Priority' dropdown for choosing task priority (e.g. High, Medium, Low), 'Create' and 'Clear' button and 'Go to Task List' link

### 'Update Task' page
'Update Task' page should contain 'Id' (disabled), 'Name' fields, 'Priority' and 'Status' dropdowns, 'Update' and 'Clear' buttons, also there should be added 'Go to Task List' link

Create also pages

    'Create New ToDo List'
    'Update ToDo List' 

Requirements for these pages are the same as the previous descriptions

Implement all needed controllers and templates

*You can use a template project as a basis
Submit links to your GitHub repository and make a short video (2-5 minutes) where demonstrate the functionality as the result of your work

## Mockup examples (using style files are optional)

### 1. 'Home' page
<img src="mockups/home.png" alt="alt text" width="400" />

### 2. 'Update Existing User' page

<img src="mockups/update_user.png" alt="alt text" width="400" />
<!-- ![](mockups/update_user.png) -->

### 3. 'Create New User' page
<img src="mockups/create_user.png" alt="alt text" width="300" />
<!-- ![](mockups/create_user.png) -->

### 4. 'All ToDo Lists of <User>' page
<img src="mockups/all_todos.png" alt="alt text" width="400" />
<!-- ![](mockups/all_todos.png) -->

### 5. 'All Tasks From <user's> ToDo List'
<img src="mockups/all_tasks.png" alt="alt text" width="400" />
<!-- ![](mockups/all_tasks.png) -->

### 6.'Create New Task' page
<img src="mockups/create_task.png" alt="alt text" width="300" />
<!-- ![](mockups/create_task.png) -->

### 7. 'Update Task' page
<img src="mockups/update_task.png" alt="alt text" width="400" />
<!-- ![](mockups/update_task.png) -->

### 8. 'Users' page
<img src="mockups/users.png" alt="alt text" width="400" />
<!-- ![](mockups/users.png) -->


## 🗄️ Database Setup

### Prerequisites
- PostgreSQL installed and running on `localhost:5432`
- Database named `todolist` created

### Configuration
Update `src/main/resources/application.properties` if needed


### Initial Data
When the application starts, your DB will be filled with data from `data.sql` file from the resources folder.

There are three users with ADMIN and USER roles in DB:

| Login         |  Password  | Role  |
| ------------- |:----------:|:-----:|
| mike@mail.com |  Qwerty0#  | ADMIN |
| nick@mail.com |  Qwerty1!  | USER  |
| nora@mail.com |  Qwerty2@  | USER  |

User with Admin role has access to all data and resources in DB.

## 🏗️ Project Structure

### ✅ Already Implemented
- **Models**: User, ToDo, Task, State (with full validation)
- **Repositories**: All repositories with Spring Data JPA
- **Services**: All services with `@Transactional` support
- **Controllers**:
  - `HomeController` - home page
  - `LoginController` - authentication
  - `StateController` - CRUD for states
  - `TaskController` - CRUD for tasks
- **Templates**:
  - home.html, login.html
  - create-user.html (registration form)
  - state templates (list, create, update)
  - task templates (create, update)

### ⚠️ To Be Implemented by Students
- **UserController** methods:
  - GET/POST `/users/create` - user registration
  - GET `/users/{id}/read` - view user info
  - GET/POST `/users/{id}/update` - update user
  - GET `/users/{id}/delete` - delete user
  - GET `/users/all` - list all users

- **ToDoController** methods:
  - GET/POST `/todos/create/users/{owner_id}` - create ToDo
  - GET/POST `/todos/{todo_id}/update/users/{owner_id}` - update ToDo
  - GET `/todos/{todo_id}/delete/users/{owner_id}` - delete ToDo
  - GET `/todos/all/users/{user_id}` - list user's ToDos
  - GET `/todos/{id}/add?user_id={userId}` - add collaborator
  - GET `/todos/{id}/remove?user_id={userId}` - remove collaborator

- **Templates to implement**:
  - update-user.html
  - user-info.html
  - users-list.html
  - create-todo.html
  - update-todo.html
  - todos-user.html
  - todo-tasks.html

## 🚀 How to Run
1. Ensure PostgreSQL is running with database `todolist`
2. Run the Spring Boot application
3. Navigate to `http://localhost:8083`
4. Login with credentials from the table above

## 📚 Technologies Used
- Spring Boot 4.0.3
- Spring MVC
- Spring Data JPA
- Thymeleaf
- PostgreSQL
- Lombok
- Bootstrap 5
- Jakarta Validation
- Java 21

## ✅ What Can Be Tested Now
- ✅ Login/Logout functionality
- ✅ Home page
- ✅ State management (full CRUD) at `/states`
- ✅ Registration form display at `/users/create`
- ⚠️ Task management (requires ToDo to be implemented first)
- ❌ User management (to be implemented)
- ❌ ToDo management (to be implemented)
