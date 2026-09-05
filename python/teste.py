import pandas as pd

df = pd.read_csv('sprint_totvs/final_limpo.csv')

df["ID_MEETING"] = (
    df["ID_MEETING"]
    .str.replace('"', '')
    .str.strip()
)

print(str(df.iloc[1130, 6]))
print(str(df.iloc[1130, 16]))
print(str(df.iloc[1130, 15]))
print(str(df.iloc[1130, 14]))



# 1130 , 1060, 954, 365, 21
