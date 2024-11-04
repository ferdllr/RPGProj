package com.ferdllr.controllers

import com.ferdllr.Models.Character
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class CharacterController {

    private val connection: Connection? = getConnection()

    init {
        createTable()
    }

    // Estabelece uma conexão com o banco de dados SQLite
    private fun getConnection(): Connection? {
        return try {
            DriverManager.getConnection("jdbc:sqlite:db.db")
        } catch (e: SQLException) {
            e.printStackTrace()
            null
        }
    }

    // Cria a tabela de personagem, se não existir
    private fun createTable() {
        val sql = """
            CREATE TABLE IF NOT EXISTS Character (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT NOT NULL,
                age INTEGER,
                description TEXT,
                race TEXT,
                FOR INTEGER,
                DEX INTEGER,
                INT INTEGER,
                SAB INTEGER,
                CAR INTEGER,
                CON INTEGER,
                hp INTEGER
            );
        """.trimIndent()

        connection?.createStatement()?.use { statement ->
            statement.execute(sql)
        }
    }

    // Função para salvar um personagem no banco de dados
    fun saveCharacter(character: Character) {
        val sql = """
            INSERT INTO Character(name, age, description, race, FOR, DEX, INT, SAB, CAR, CON, hp) 
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """

        connection?.prepareStatement(sql)?.use { preparedStatement ->
            preparedStatement.setString(1, character.name)
            preparedStatement.setInt(2, character.age)
            preparedStatement.setString(3, character.desc)
            preparedStatement.setString(4, character.race?.name ?: "Unknown")
            preparedStatement.setInt(5, character.FOR)
            preparedStatement.setInt(6, character.DEX)
            preparedStatement.setInt(7, character.INT)
            preparedStatement.setInt(8, character.SAB)
            preparedStatement.setInt(9, character.CAR)
            preparedStatement.setInt(10, character.CON)
            preparedStatement.setInt(11, character.hp)
            preparedStatement.executeUpdate()
        }
    }

    // Função para atualizar um personagem no banco de dados
    fun updateCharacter(character: Character) {
        val sql = """
            UPDATE Character
            SET age = ?, description = ?, race = ?, FOR = ?, DEX = ?, INT = ?, SAB = ?, CAR = ?, CON = ?, hp = ?
            WHERE name = ?
        """

        connection?.prepareStatement(sql)?.use { preparedStatement ->
            preparedStatement.setInt(1, character.age)
            preparedStatement.setString(2, character.desc)
            preparedStatement.setString(3, character.race?.name ?: "Unknown")
            preparedStatement.setInt(4, character.FOR)
            preparedStatement.setInt(5, character.DEX)
            preparedStatement.setInt(6, character.INT)
            preparedStatement.setInt(7, character.SAB)
            preparedStatement.setInt(8, character.CAR)
            preparedStatement.setInt(9, character.CON)
            preparedStatement.setInt(10, character.hp)
            preparedStatement.setString(11, character.name)
            preparedStatement.executeUpdate()
        }
    }

    // Função para excluir um personagem do banco de dados
    fun deleteCharacter(name: String) {
        val sql = "DELETE FROM Character WHERE name = ?"

        connection?.prepareStatement(sql)?.use { preparedStatement ->
            preparedStatement.setString(1, name)
            preparedStatement.executeUpdate()
        }
    }

    // Função para carregar um personagem pelo nome
    fun loadCharacter(name: String): Character? {
        val sql = "SELECT * FROM Character WHERE name = ?"
        var character: Character? = null

        connection?.prepareStatement(sql)?.use { preparedStatement ->
            preparedStatement.setString(1, name)
            val resultSet = preparedStatement.executeQuery()
            if (resultSet.next()) {
                character = Character().apply {
                    this.name = resultSet.getString("name")
                    this.age = resultSet.getInt("age")
                    this.desc = resultSet.getString("description")
                    this.FOR = resultSet.getInt("FOR")
                    this.DEX = resultSet.getInt("DEX")
                    this.INT = resultSet.getInt("INT")
                    this.SAB = resultSet.getInt("SAB")
                    this.CAR = resultSet.getInt("CAR")
                    this.CON = resultSet.getInt("CON")
                    this.hp = resultSet.getInt("hp")
                    // Definir a raça conforme necessário
                }
            }
        }
        return character
    }

    // Nova função para carregar todos os personagens
    fun loadAllCharacters(): List<Character> {
        val sql = "SELECT * FROM Character"
        val characters = mutableListOf<Character>()

        connection?.createStatement()?.use { statement ->
            val resultSet = statement.executeQuery(sql)
            while (resultSet.next()) {
                val character = Character().apply {
                    this.name = resultSet.getString("name")
                    this.age = resultSet.getInt("age")
                    this.desc = resultSet.getString("description")
                    this.FOR = resultSet.getInt("FOR")
                    this.DEX = resultSet.getInt("DEX")
                    this.INT = resultSet.getInt("INT")
                    this.SAB = resultSet.getInt("SAB")
                    this.CAR = resultSet.getInt("CAR")
                    this.CON = resultSet.getInt("CON")
                    this.hp = resultSet.getInt("hp")
                    // Definir a raça conforme necessário
                }
                characters.add(character)
            }
        }
        return characters
    }
}
