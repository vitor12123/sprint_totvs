import pandas as pd
import mysql.connector

df = pd.read_csv('/home/tristeza/Documents/trabalho mae/sprint_java/sprint_totvs/final_limpo.csv')

# Limpeza dos dados
df["ID_MEETING"] = df["ID_MEETING"].str.replace('"', '').str.strip()
df["NOTA_NPS"] = df["NOTA_NPS"].str.replace('"', '').str.strip()

conexao = mysql.connector.connect(
    host="127.0.0.1",
    port=3306,
    user="root",
    password="vitor784!",
    database="totvs",
)
cursor = conexao.cursor()

for i in range(len(df)):
    try:
        id_clie = str(df.iloc[i, 6])
        nm_seg = str(df.iloc[i, 14]) 
        dt_pesquisa = str(df.iloc[i, 16])


        
        cursor.execute("""
            INSERT INTO clie (id_clie, dt_ultima_pesquisa, nm_segm)
            VALUES (%s, %s, %s)
        """, (id_clie, dt_pesquisa, nm_seg))
        
    except Exception as e:
        print(f"❌ Erro na linha {i}: {e}")
        continue

conexao.commit()
cursor.close()
conexao.close()