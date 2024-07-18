from pyhive import hive

with hive.connect(host="docker-hive-master-hive-server-1", port="10000", database="loans", username="hive", password="hive", auth="CUSTOM").cursor() as cur:
    cur.execute("SELECT * FROM loans WHERE amount > 3000")
    for i in cur.fetchall():
        print(i)