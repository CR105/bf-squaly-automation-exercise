Feature: Tomando como referencia lo documentado en este swagger:
            https://petstore.swagger.io/
          *Agregar una mascota realizando un POST al path /v2/pet.
          *Realizar un GET /v2/pet/{petId} para obtener una mascota existente.
          *Modificar una mascota existente mediante PUT al path /v2/pet.
        En todos los casos validar:
            *Status code esperado.
            *Schema del response.

  Background:
    * url 'https://petstore.swagger.io/v2'
    * def schema = read('schema.json')
    * def dataJson = read('data.json')
    * def newIdPet = 86498411
    * def updateIdPet = 82398455

    # Agregar una mascota realizando un POST al path /v2/pet.
  Scenario: Add new pet
    Given path 'pet'
    And set dataJson.id = newIdPet
    And request dataJson
    When method POST
    Then status 200
    And match response == schema

  # Realizar un GET /v2/pet/{petId} para obtener una mascota existente.
  Scenario: Get and existing pet
    Given path 'pet', newIdPet
    When method GET
    Then status 200
    And match response == schema

    # Modificar una mascota existente mediante PUT al path /v2/pet.
  Scenario: Update an existing pet
    Given path 'pet'
    And set dataJson.id = updateIdPet
    And request dataJson
    When method PUT
    Then status 200
    And match response == schema