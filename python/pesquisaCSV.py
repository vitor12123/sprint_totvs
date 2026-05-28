import pandas as pd
import mysql.connector

df = pd.read_csv('/home/tristeza/Documents/trabalho mae/sprint_java/sprint_totvs/final_limpo.csv')

df["ID_MEETING"] = (
    df["ID_MEETING"]
    .str.replace('"', '')
    .str.strip()
)

conexao = mysql.connector.connect(
    host="127.0.0.1",
    port=3306,
    user="root",
    password="vitor784!",
    database="totvs",
    
)

cursor = conexao.cursor()

pesquisa = input("Digite o ID da reunião: ")
texto = df["ANON_TRANSCRICAO"]
id_texto = df["ID_MEETING"]


if pesquisa in id_texto.values:
    print(texto[id_texto == pesquisa].values[0])
else:
    print("ID da reunião não encontrado.")

for i in range(len(df)):
    try:
        nm_seg = str(df.iloc[i, 15])
        nota_nps = str(df.iloc[i, 18])
        dt_pesquisa = str(df.iloc[i, 17])

        cursor.execute("""
            INSERT INTO clie (nt_nps, dt_ultima_pesquisa, nm_seg)
            VALUES (%s, %s, %s)
        """, (nota_nps, dt_pesquisa, nm_seg))
    except Exception as e:
        print(f"❌ Erro na linha {i}: {e}")
        break

conexao.commit()
cursor.close()
conexao.close()