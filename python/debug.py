import pandas as pd
import mysql.connector

df = pd.read_csv('/home/tristeza/Documents/trabalho mae/sprint_java/sprint_totvs/final_limpo.csv')

conexao = mysql.connector.connect(
    host="127.0.0.1",
    port=3306,
    user="root",
    password="vitor784!",
    database="totvs",
)
cursor = conexao.cursor()

certo = 5
errado = 6

for i in range(len(df) - 3):
    try:
        cursor.execute("""
            update conv set id_conv = %s where id_conv = %s
        """, (certo, errado))
        
    except Exception as e:
        print(f"❌ Erro na linha {i}: {e}")
        continue

    certo += 1
    errado += 1
conexao.commit()
cursor.close()
conexao.close()