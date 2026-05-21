import pandas as pd
import mysql.connector

df = pd.read_csv('../final_limpo.csv')

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

for i in range(len(df)):
        try:
            # Pega os valores da linha i
            id_meet = str(df.iloc[i, 0])
            dt_conv = str(df.iloc[i, 1])
            tr_conv = str(df.iloc[i, 10])
            st_conv = str(df.iloc[i, 4])
            id_clie = str(df.iloc[i, 6])
            
            cursor.execute("""
                INSERT INTO conv (id_meet, id_clie, dt_conv, tr_conv, st_conv)
                VALUES (%s, %s, %s, %s, %s)
            """, (id_meet, id_clie, dt_conv, tr_conv, st_conv))
        except Exception as e:
            print(f"❌ Erro na linha {i}: {e}")
            continue

conexao.commit()
cursor.close()
conexao.close()



