import pandas as pd

df = pd.read_csv('../final_limpo.csv')

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