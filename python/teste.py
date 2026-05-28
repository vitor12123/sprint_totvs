import pandas as pd

df = pd.read_csv('/home/tristeza/Documents/trabalho mae/sprint_java/sprint_totvs/final_limpo.csv')

df["ID_MEETING"] = (
    df["ID_MEETING"]
    .str.replace('"', '')
    .str.strip()
)

print(df["ID_MEETING"][5])

for i in range(len(df)):    
    print(str(df.iloc[i, 6]))
    print(str(df.iloc[i, 14]))
    print(str(df.iloc[i, 16]))
