DROP procedure IF EXISTS `customer_insert`;
//
DELIMITER //
CREATE PROCEDURE customer_insert(
OUT p_customer_id INT ,
IN p_name varchar(30), 
IN p_last_name varchar(30),
IN p_birth_date datetime
)
BEGIN
	 INSERT INTO customer(		
		name,
        last_name,
        birth_date
	)
	VALUES(
		p_name ,
		p_last_name ,
		p_birth_date);	
		
	SET p_customer_id = LAST_INSERT_ID();
	    	 
END;
//
DROP procedure IF EXISTS `customer_find_all`;
//
DELIMITER //
CREATE PROCEDURE customer_find_all()
BEGIN
   SELECT 
   		  customer_id AS customerId,
   		  name,
	      last_name AS lastName,
          birth_date AS birthDate
   FROM customer ;
END;
//