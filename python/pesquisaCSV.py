import pandas as pd
import mysql.connector

df = pd.read_csv('sprint_totvs/final_limpo.csv')

# Limpeza dos dados
df["ID_MEETING"] = df["ID_MEETING"].str.replace('"', '').str.strip()
df["NOTA_NPS"] = df["NOTA_NPS"].str.replace('"', '').str.strip()

conexao = mysql.connector.connect(
    host="127.0.0.1",
    port=3306,
    user="root",
    password="Vitor123!",
    database="teste1",
)
cursor = conexao.cursor()

for i in range(len(df)):
    try:
        pk_reu = str(df.iloc[i, 0])
        fk_pk_cli = str(df.iloc[i, 6])
        nt_nps_reu = str(df.iloc[i, 17])
        tr_reu = str(df.iloc[i, 10])
        dt_reu = str(df.iloc[i, 1])

        pk_cli = str(df.iloc[i, 6])
        dt_ultpes_cli = str(df.iloc[i, 16])
        fax_fat_cli = str(df.iloc[i, 15])
        nm_seg_cli = str(df.iloc[i, 14])


        
        cursor.execute("""
            INSERT INTO cliente (pk_reu, fk_pk_cli, nt_nps_reu, tr_reu, dt_reu)
            VALUES (%s, %s, %s, %s, %s)
        """, (pk_reu, fk_pk_cli, nt_nps_reu, tr_reu, dt_reu))
        
    except Exception as e:
        print(f"Erro na linha {i}: {e}")
        continue

conexao.commit()
cursor.close()
conexao.close()

# 1130 , 1060, 954, 365, 21