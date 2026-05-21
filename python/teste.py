import mysql.connector

conexao = mysql.connector.connect(
    host="127.0.0.1",
    port=3306,
    user="root",
    password="vitor784!",
    database="totvs",
    
)

cursor = conexao.cursor()

cursor.execute("DESCRIBE conv")
for coluna in cursor.fetchall():
    print(coluna)


