import pandas as pd

df = pd.read_csv('final_limpo.csv')

df["ID_MEETING"] = (
    df["ID_MEETING"]
    .str.replace('"', '')
    .str.strip()
)

print(df["ID_MEETING"][5])

for i in range(len(df)): 
    print(str(df.iloc[i, 3]))   
    print(str(df.iloc[i, 6]))
    print(str(df.iloc[i, 7]))
    print(str(df.iloc[i, 8]))
    print(str(df.iloc[i, 11]))
    print(str(df.iloc[i, 12]))
    print(str(df.iloc[i, 14]))
    print(str(df.iloc[i, 15]))
    print(str(df.iloc[i, 17]))
