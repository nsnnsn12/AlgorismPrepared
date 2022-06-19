-- Join 있었는데요 없었습니다
SELECT i.animal_id
     , i.name
from animal_ins i, animal_outs o
where i.animal_id = o.animal_id(+)
and o.datetime is not null
and i.datetime > o.datetime
order by i.datetime