import pandas as pd
import mysql.connector

df = pd.read_csv('final_limpo.csv')

df["ID_MEETING"] = (
    df["ID_MEETING"]
    .str.replace('"', '')
    .str.strip()
)

pesquisa = input("Digite o ID da reunião: ")
texto = df["ANON_TRANSCRICAO"]
id_texto = df["ID_MEETING"]

if pesquisa in id_texto.values:
    print(texto[id_texto == pesquisa].values[0])
else:
    print("ID da reunião não encontrado.")

conexao = mysql.connector.connect(
    host="localhost:3306",
    user="root784",
    password="vitor784!",
    database="dataBase",
    
)

cursor = conexao.cursor()

for linha in df.iterrows():

    cursor.execute(
        """
        INSERT INTO reuniao (
            id_meeting,
            dt_meeting,
            formato_meeting
        )
        VALUES (%s, %s, %s)
        """,
        (
            linha["ID_MEETING"],
            linha["DT_MEETING"],
            linha["FORMATO_MEETING"]
        )
    )

conexao.commit()

