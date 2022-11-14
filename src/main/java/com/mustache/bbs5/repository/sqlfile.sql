SELECT * FROM likelion.nation_wide_hospitals where (hospital_name like '%피부%' and full_address like '%수원%') ;

SELECT business_type_name, hospital_name, road_name_address
FROM `likelion-db`.nation_wide_hospitals
where business_type_name in ('보건소', '보건지소')

SELECT * FROM `likelion-db`.nation_wide_hospitals
where business_type_name in ('보건소', '보건지소', '보건진료소')
and road_name_address like '%광진구%'
;