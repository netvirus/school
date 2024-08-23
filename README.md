### Описание программы учета товарно-материальных ценностей для школы

#### **Цель программы:**
Программа предназначена для учета и управления товарно-материальными ценностями (ТМЦ) в школе. Она позволяет отслеживать поступление и расход ТМЦ, контролировать выдачу ценностей ученикам, а также вести учет ответственных лиц за их выдачу.

#### **Основные сущности и их атрибуты:**

1. **Товарно-материальные ценности (ТМЦ)**:
  - **ID**: Уникальный идентификатор ТМЦ.
  - **Название**: Название ТМЦ (например, учебники, униформа, спортивный инвентарь).
  - **Тип**: Тип ТМЦ (например, книга, одежда, спортивный инвентарь).
  - **Цвет**: Цвет ТМЦ.
  - **Количество**: Количество единиц ТМЦ.
  - **Размер** (если применимо): Размер для одежды.
  - **Предмет** (если применимо): Предмет для учебников.
  - **Класс/Грейд** (если применимо): Грейд для учебников.

2. **Ученик**:
  - **ID**: Уникальный идентификатор ученика.
  - **Имя**: Имя ученика.
  - **Фамилия**: Фамилия ученика.
  - **Класс**: Класс ученика (например, 5-й класс).

3. **Ответственный**:
  - **ID**: Уникальный идентификатор ответственного лица.
  - **Имя**: Имя ответственного лица.
  - **Фамилия**: Фамилия ответственного лица.
  - **Должность**: Должность в школе (например, завхоз, учитель, директор).

4. **Ведомость поступления**:
  - **ID**: Уникальный идентификатор ведомости поступления.
  - **ТМЦ**: Список поступивших ТМЦ (с указанием количества).
  - **Дата поступления**: Дата поступления ТМЦ.
  - **Ответственный**: Ответственное лицо за поступление.

5. **Ведомость расхода**:
  - **ID**: Уникальный идентификатор ведомости расхода.
  - **ТМЦ**: Список выданных ТМЦ (с указанием количества).
  - **Дата выдачи**: Дата выдачи ТМЦ.
  - **Ученик**: Ученик, которому выданы ТМЦ.
  - **Ответственный**: Ответственное лицо за выдачу.

#### **Функциональные возможности программы:**

1. **Учет ТМЦ**:
  - Ведение списка ТМЦ с возможностью добавления, редактирования и удаления записей.
  - Возможность указания количества, типа, цвета, размера, предмета и класса для каждой ТМЦ.

2. **Учет учеников и ответственных лиц**:
  - Ведение списка учеников и ответственных лиц с возможностью добавления, редактирования и удаления записей.
  - Возможность указания класса для учеников и должности для ответственных лиц.

3. **Ведомости поступления**:
  - Создание ведомостей поступления ТМЦ.
  - Ведение истории поступления с указанием даты, ответственного лица и списка поступивших ТМЦ.

4. **Ведомости расхода**:
  - Создание ведомостей расхода ТМЦ.
  - Ведение истории выдачи с указанием даты, ученика, ответственного лица и списка выданных ТМЦ.

5. **Отчеты и аналитика**:
  - Формирование отчетов по поступлению и расходу ТМЦ за определенные периоды.
  - Возможность фильтрации отчетов по дате, ученику, ответственному лицу или типу ТМЦ.

#### **Пользовательские роли:**

1. **Администратор**:
  - Полный доступ ко всем функциям программы.
  - Управление учетными записями пользователей.

2. **Ответственный за ТМЦ**:
  - Доступ к функциям учета ТМЦ, ведомостям поступления и расхода.
  - Формирование отчетов.

3. **Пользователь (например, учитель)**:
  - Ограниченный доступ к функциям программы.
  - Возможность просмотра информации о ТМЦ и отчетов.

#### **Примеры сценариев использования:**

1. **Поступление новой партии учебников:**
  - Ответственное лицо создаёт ведомость поступления, указывая дату, список поступивших учебников, их количество и цвет.
  - Ведомость сохраняется в системе, и данные о поступивших учебниках автоматически добавляются в общий список ТМЦ.

2. **Выдача униформы ученикам:**
  - Ответственное лицо создаёт ведомость расхода, указывая дату выдачи, список выданной униформы, ученика и ответственного за выдачу.
  - Ведомость сохраняется в системе, и данные о выданной униформе вычитаются из общего списка ТМЦ.

3. **Формирование отчета по расходу ТМЦ:**
  - Пользователь формирует отчет за определенный период, выбирая необходимые фильтры (например, тип ТМЦ, класс, ученик).
  - Отчет отображает информацию о всех расходах ТМЦ за указанный период.

Эта программа поможет школам эффективно управлять ТМЦ, упрощая процессы их учета, выдачи и анализа использования. Если у тебя есть дополнительные требования или вопросы, дай знать!

### Общая структура ответа api

Ответы для всех GET запросов (включая `/all` и `/{id}`) возвращают JSON объект (или массив объектов) со следующими полями:

#### **Общие поля для всех сущностей:**
- **id**: Уникальный идентификатор (тип: Long)
- **name**: Имя (тип: String)
- **color**: Цвет (тип: String)

#### **Дополнительные поля для `Uniform` и её потомков:**
- **size**: Размер (тип: String)

#### **Дополнительные поля для `Books`:**
- **unit**: Предмет (тип: String)
- **grade**: Класс/Грейд (тип: int)

### 1. **Shirt**

#### **GET** `/api/things/shirts`
- **Возвращает:** Массив объектов `Shirt`
- **Формат:**
  ```json
  [
    {
      "id": 1,
      "name": "Shirt 1",
      "color": "Red",
      "size": "M"
    },
    {
      "id": 2,
      "name": "Shirt 2",
      "color": "Blue",
      "size": "4"
    }
  ]
  ```

#### **GET** `/api/things/shirts/{id}`
- **Возвращает:** Объект `Shirt`
- **Формат:**
  ```json
  {
    "id": 1,
    "name": "Shirt 1",
    "color": "Red",
    "size": "5"
  }
  ```

#### **POST** `/api/things/shirts`
- **Принимает:** JSON объект для создания нового `Shirt`.
- **Пример:**
  ```json
  {
    "name": "New Shirt",
    "color": "Green",
    "size": "3"
  }
  ```

- **Возвращает:** Созданный объект `Shirt` с заполненным `id`.
- **Формат:**
  ```json
  {
    "id": 3,
    "name": "New Shirt",
    "color": "Green",
    "size": "3"
  }
  ```

#### **PUT** `/api/things/shirts/{id}`
- **Принимает:** JSON объект с обновленными данными для `Shirt`.
- **Пример:**
  ```json
  {
    "name": "Updated Shirt",
    "color": "Yellow",
    "size": "13"
  }
  ```

- **Возвращает:** Обновленный объект `Shirt`.
- **Формат:**
  ```json
  {
    "id": 1,
    "name": "Updated Shirt",
    "color": "Yellow",
    "size": "13"
  }
  ```

#### **DELETE** `/api/things/shirts/{id}`
- **Действие:** Удаляет объект `Shirt` по `id`.
- **Возвращает:** Пустой ответ с кодом 204 No Content, если успешно.

### 2. **Shorts**

#### **GET** `/api/things/shorts`
- **Возвращает:** Массив объектов `Shorts`
- **Формат:**
  ```json
  [
    {
      "id": 1,
      "name": "Shorts 1",
      "color": "Black",
      "size": "4"
    },
    {
      "id": 2,
      "name": "Shorts 2",
      "color": "White",
      "size": "2"
    }
  ]
  ```

#### **GET** `/api/things/shorts/{id}`
- **Возвращает:** Объект `Shorts`
- **Формат:**
  ```json
  {
    "id": 1,
    "name": "Shorts 1",
    "color": "Black",
    "size": "4"
  }
  ```

#### **POST** `/api/things/shorts`
- **Принимает:** JSON объект для создания нового `Shorts`.
- **Пример:**
  ```json
  {
    "name": "New Shorts",
    "color": "Green",
    "size": "5"
  }
  ```

- **Возвращает:** Созданный объект `Shorts` с заполненным `id`.
- **Формат:**
  ```json
  {
    "id": 3,
    "name": "New Shorts",
    "color": "Green",
    "size": "5"
  }
  ```

#### **PUT** `/api/things/shorts/{id}`
- **Принимает:** JSON объект с обновленными данными для `Shorts`.
- **Пример:**
  ```json
  {
    "name": "Updated Shorts",
    "color": "Yellow",
    "size": "13"
  }
  ```

- **Возвращает:** Обновленный объект `Shorts`.
- **Формат:**
  ```json
  {
    "id": 1,
    "name": "Updated Shorts",
    "color": "Yellow",
    "size": "13"
  }
  ```

#### **DELETE** `/api/things/shorts/{id}`
- **Действие:** Удаляет объект `Shorts` по `id`.
- **Возвращает:** Пустой ответ с кодом 204 No Content, если успешно.

### 3. **Pants**

#### **GET** `/api/things/pants`
- **Возвращает:** Массив объектов `Pants`
- **Формат:**
  ```json
  [
    {
      "id": 1,
      "name": "Pants 1",
      "color": "Gray",
      "size": "3"
    },
    {
      "id": 2,
      "name": "Pants 2",
      "color": "Navy",
      "size": "3"
    }
  ]
  ```

#### **GET** `/api/things/pants/{id}`
- **Возвращает:** Объект `Pants`
- **Формат:**
  ```json
  {
    "id": 1,
    "name": "Pants 1",
    "color": "Gray",
    "size": "4"
  }
  ```

#### **POST** `/api/things/pants`
- **Принимает:** JSON объект для создания нового `Pants`.
- **Пример:**
  ```json
  {
    "name": "New Pants",
    "color": "Green",
    "size": "5"
  }
  ```

- **Возвращает:** Созданный объект `Pants` с заполненным `id`.
- **Формат:**
  ```json
  {
    "id": 3,
    "name": "New Pants",
    "color": "Green",
    "size": "5"
  }
  ```

#### **PUT** `/api/things/pants/{id}`
- **Принимает:** JSON объект с обновленными данными для `Pants`.
- **Пример:**
  ```json
  {
    "name": "Updated Pants",
    "color": "Yellow",
    "size": "13"
  }
  ```

- **Возвращает:** Обновленный объект `Pants`.
- **Формат:**
  ```json
  {
    "id": 1,
    "name": "Updated Pants",
    "color": "Yellow",
    "size": "12"
  }
  ```

#### **DELETE** `/api/things/pants/{id}`
- **Действие:** Удаляет объект `Pants` по `id`.
- **Возвращает:** Пустой ответ с кодом 204 No Content, если успешно.

### 4. **Skirt**

#### **GET** `/api/things/skirts`
- **Возвращает:** Массив объектов `Skirt`
- **Формат:**
  ```json
  [
    {
      "id": 1,
      "name": "Skirt 1",
      "color": "Black",
      "size": "3"
    },
    {
      "id": 2,
      "name": "Skirt 2",
      "color": "White",
      "size": "4"
    }
  ]
  ```

#### **GET** `/api/things/skirts/{id}`
- **Возвращает:** Объект `Skirt`
- **Формат:**
  ```json
  {
    "id": 1,
    "name": "Skirt 1",
    "color": "Black",
    "size": "5"
  }
  ```

#### **POST** `/api/things/skirts`
- **Принимает:** JSON объект для создания нового `Skirt`.
- **Пример:**
  ```json
  {
    "name": "New Skirt",
    "color": "Green",
    "size": "6"
  }
  ```

- **Возвращает:** Созданный объект `Skirt` с заполненным `id`.
- **Формат:**
  ```json
  {
    "id": 3,
    "name": "New Skirt",
    "color": "Green",
    "size": "5"
  }
  ```

#### **PUT** `/api/things/skirts/{id}`
- **Принимает:** JSON объект с обновленными данными для `Skirt`.
- **Пример:**
  ```json
  {
    "name": "Updated Skirt",
    "color": "Yellow",
    "size": "11"
  }
  ```

- **Возвращает:** Обновленный объект `Skirt`.
- **Формат:**
  ```json
  {
    "id": 1,
    "name": "Updated Skirt",
    "color": "Yellow",
    "size": "11"
  }
  ```

#### **DELETE** `/api/things/skirts/{id}`
- **Действие:** Удаляет объект `Skirt` по `id`.
- **Возвращает:** Пустой ответ с кодом 204 No Content, если успешно.

### 5. **Books**

#### **GET** `/api/things/books`
- **Возвращает:** Массив объектов `Books`
- **Формат:**
  ```json
  [
    {
      "id": 1,
      "name": "Math Book",
      "color": "Red",
      "unit": "Mathematics",
      "grade": 4
    },
    {
      "id": 2,
      "name": "Science Book",
      "color": "Blue",
      "unit": "Science",
      "grade": 3
    }
  ]
  ```

#### **GET** `/api/things/books/{id}`
- **Возвращает:** Объект `Books`
- **Формат:**
  ```json
  {
    "id": 1,
    "name": "Math Book",
    "color": "Red",
    "unit": "Mathematics",
    "grade": 4
  }
  ```

#### **POST** `/api/things/books`
- **Принимает:** JSON объект для создания нового `Books`.
- **Пример:**
  ```json
  {
    "name": "New Book",
    "color": "Green",
    "unit": "History",
    "grade": 2
  }
  ```

- **Возвращает:** Созданный объект `Books` с заполненным `id`.
- **Формат:**
  ```json
  {
    "id": 3,
    "name": "New Book",
    "color": "Green",
    "unit": "History",
    "grade": 2
  }
  ```

#### **PUT** `/api/things/books/{id}`
- **Принимает:** JSON объект с обновленными данными для `Books`.
- **Пример:**
  ```json
  {
    "name": "Updated Book",
    "color": "Yellow",
    "unit": "Literature",
    "grade": 5
  }
  ```

- **Возвращает:** Обновленный объект `Books`.
- **Формат:**
  ```json
  {
    "id": 1,
    "name": "Updated Book",
    "color": "Yellow",
    "unit": "Literature",
    "grade": 5
  }
  ```

#### **DELETE** `/api/things/books/{id}`
- **Действие:** Удаляет объект `Books` по `id`.
- **Возвращает:** Пустой ответ с кодом 204 No Content, если успешно.

Конечно, вот список всех новых API запросов в `PersonController` с примерами запросов и ответов в формате JSON.

### 1. **Student API**

#### **GET** `/api/persons/students`
- **Описание:** Возвращает список всех студентов.
- **Пример запроса:**
  ```bash
  GET /api/persons/students
  ```
- **Пример ответа:**
  ```json
  [
    {
      "id": 1,
      "firstName": "John",
      "lastName": "Doe",
      "age": 15,
      "gender": "Male",
      "nationality": "American",
      "phoneNumber": "123-456-7890",
      "address": "123 Main St",
      "grade": "10th",
      "motherName": "Jane Doe",
      "fatherName": "Joe Doe",
      "motherPhoneNumber": "123-456-7891",
      "fatherPhoneNumber": "123-456-7892"
    },
    {
      "id": 2,
      "firstName": "Jane",
      "lastName": "Smith",
      "age": 14,
      "gender": "Female",
      "nationality": "British",
      "phoneNumber": "987-654-3210",
      "address": "456 Elm St",
      "grade": "9th",
      "motherName": "Ann Smith",
      "fatherName": "John Smith",
      "motherPhoneNumber": "987-654-3211",
      "fatherPhoneNumber": "987-654-3212"
    }
  ]
  ```

#### **GET** `/api/persons/students/{id}`
- **Описание:** Возвращает информацию о конкретном студенте по его ID.
- **Пример запроса:**
  ```bash
  GET /api/persons/students/1
  ```
- **Пример ответа:**
  ```json
  {
    "id": 1,
    "firstName": "John",
    "lastName": "Doe",
    "age": 15,
    "gender": "Male",
    "nationality": "American",
    "phoneNumber": "123-456-7890",
    "address": "123 Main St",
    "grade": "10th",
    "motherName": "Jane Doe",
    "fatherName": "Joe Doe",
    "motherPhoneNumber": "123-456-7891",
    "fatherPhoneNumber": "123-456-7892"
  }
  ```

#### **POST** `/api/persons/students`
- **Описание:** Создает нового студента.
- **Пример запроса:**
  ```bash
  POST /api/persons/students
  Content-Type: application/json

  {
    "firstName": "Tom",
    "lastName": "Brown",
    "age": 16,
    "gender": "Male",
    "nationality": "Canadian",
    "phoneNumber": "111-222-3333",
    "address": "789 Maple St",
    "grade": "11th",
    "motherName": "Mary Brown",
    "fatherName": "James Brown",
    "motherPhoneNumber": "111-222-3334",
    "fatherPhoneNumber": "111-222-3335"
  }
  ```
- **Пример ответа:**
  ```json
  {
    "id": 3,
    "firstName": "Tom",
    "lastName": "Brown",
    "age": 16,
    "gender": "Male",
    "nationality": "Canadian",
    "phoneNumber": "111-222-3333",
    "address": "789 Maple St",
    "grade": "11th",
    "motherName": "Mary Brown",
    "fatherName": "James Brown",
    "motherPhoneNumber": "111-222-3334",
    "fatherPhoneNumber": "111-222-3335"
  }
  ```

#### **PUT** `/api/persons/students/{id}`
- **Описание:** Обновляет данные студента по его ID.
- **Пример запроса:**
  ```bash
  PUT /api/persons/students/1
  Content-Type: application/json

  {
    "firstName": "John",
    "lastName": "Doe",
    "age": 16,
    "gender": "Male",
    "nationality": "American",
    "phoneNumber": "123-456-7890",
    "address": "123 Main St",
    "grade": "11th",
    "motherName": "Jane Doe",
    "fatherName": "Joe Doe",
    "motherPhoneNumber": "123-456-7891",
    "fatherPhoneNumber": "123-456-7892"
  }
  ```
- **Пример ответа:**
  ```json
  {
    "id": 1,
    "firstName": "John",
    "lastName": "Doe",
    "age": 16,
    "gender": "Male",
    "nationality": "American",
    "phoneNumber": "123-456-7890",
    "address": "123 Main St",
    "grade": "11th",
    "motherName": "Jane Doe",
    "fatherName": "Joe Doe",
    "motherPhoneNumber": "123-456-7891",
    "fatherPhoneNumber": "123-456-7892"
  }
  ```

#### **DELETE** `/api/persons/students/{id}`
- **Описание:** Удаляет студента по его ID.
- **Пример запроса:**
  ```bash
  DELETE /api/persons/students/1
  ```
- **Пример ответа:**
  ```bash
  HTTP/1.1 204 No Content
  ```

### 2. **Teacher API**

#### **GET** `/api/persons/teachers`
- **Описание:** Возвращает список всех учителей.
- **Пример запроса:**
  ```bash
  GET /api/persons/teachers
  ```
- **Пример ответа:**
  ```json
  [
    {
      "id": 1,
      "firstName": "Alice",
      "lastName": "Green",
      "age": 30,
      "gender": "Female",
      "nationality": "American",
      "phoneNumber": "222-333-4444",
      "address": "101 Oak St",
      "subject": "Mathematics",
      "grade": "10th"
    },
    {
      "id": 2,
      "firstName": "Bob",
      "lastName": "White",
      "age": 45,
      "gender": "Male",
      "nationality": "British",
      "phoneNumber": "555-666-7777",
      "address": "202 Pine St",
      "subject": "Science",
      "grade": "9th"
    }
  ]
  ```

#### **GET** `/api/persons/teachers/{id}`
- **Описание:** Возвращает информацию о конкретном учителе по его ID.
- **Пример запроса:**
  ```bash
  GET /api/persons/teachers/1
  ```
- **Пример ответа:**
  ```json
  {
    "id": 1,
    "firstName": "Alice",
    "lastName": "Green",
    "age": 30,
    "gender": "Female",
    "nationality": "American",
    "phoneNumber": "222-333-4444",
    "address": "101 Oak St",
    "subject": "Mathematics",
    "grade": "10th"
  }
  ```

#### **POST** `/api/persons/teachers`
- **Описание:** Создает нового учителя.
- **Пример запроса:**
  ```bash
  POST /api/persons/teachers
  Content-Type: application/json

  {
    "firstName": "Charlie",
    "lastName": "Brown",
    "age": 40,
    "gender": "Male",
    "nationality": "Canadian",
    "phoneNumber": "888-999-0000",
    "address": "303 Cedar St",
    "subject": "History",
    "grade": "11th"
  }
  ```
- **Пример ответа:**
  ```json
  {
    "id": 3,
    "firstName": "Charlie",
    "lastName": "Brown",
    "age": 40,
    "gender": "Male",
    "nationality": "Canadian",
    "phoneNumber": "888-999-0000",
    "address": "303 Cedar St",
    "subject": "History",
    "grade": "11th"
  }
  ```

#### **PUT** `/api/persons/teachers/{id}`
- **Описание:** Обновляет данные учителя по его ID.
- **Пример запроса:**
  ```bash
  PUT /api/persons/teachers/1
  Content-Type: application/json

  {
    "firstName": "Alice",
    "lastName": "Green",
    "age": 31,
    "gender": "Female",
    "nationality": "American",
    "phoneNumber": "222-333-4444",
    "address": "101 Oak St",
    "subject": "Mathematics",
    "grade": "11th"
  }
  ```
- **Пример ответа:**
  ```json
  {
    "id": 1,
    "firstName": "Alice",
    "lastName": "Green",
    "age": 31,
    "gender": "Female",
    "nationality": "American",
    "phoneNumber": "222-333-4444",
    "address": "101 Oak St",
    "subject": "Mathematics",
    "grade": "11th"
  }
  ```

#### **DELETE** `/api/persons/teachers/{id}`
- **Описание:** Удаляет учителя по его ID.
- **Пример запроса:**
  ```bash
  DELETE /api/persons/teachers/1
  ```
- **Пример ответа:**
  ```bash
  HTTP/1.1 204 No Content
  ```
