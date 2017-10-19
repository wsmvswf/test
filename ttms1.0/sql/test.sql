
select c.id,c.name,c.parentId,p.name parentName
from tms_classes c left join tms_classes p
on c.parentId=p.id


select c.id,c.name,c.parentId,
 (select name 
  from tms_classes p 
  where c.parentId=p.id) parentName
from tms_classes c;