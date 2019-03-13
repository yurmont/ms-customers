DROP procedure IF EXISTS `document_insert`;
//
DELIMITER //
CREATE PROCEDURE document_insert(
IN p_company_id varchar(11), 
IN p_ruc varchar(11),
IN p_document_id varchar(20),
IN p_document_reference varchar(20), 
IN p_logistic_center_id char(4),
IN p_logistic_center_description varchar(100),
IN p_material_id varchar(20), 
IN p_material_description varchar(100),
IN p_issue_date date,
IN p_expiration_date date,
IN p_currency_id char(3),
IN p_fiscal_year int(11),
IN p_document_class char(2),
IN p_position_sap char(3),
IN p_segment varchar(5),
IN p_register_user_id int(11),
IN p_register_user_fullname varchar(100)
)
BEGIN
	 INSERT INTO document(
		company_id ,
		ruc ,
		document_id ,
		document_reference,
		logistic_center_id,
		logistic_center_description,
		material_id,
		material_description,		
		issue_date,
		expiration_date,
		currency_id,		
		fiscal_year,
		document_class,
        position_sap,
        segment,
		register_user_id,
		register_user_fullname,
		register_datetime
	)
	VALUES(
		p_company_id ,
		p_ruc ,
		p_document_id ,
		p_document_reference,
		p_logistic_center_id,
		p_logistic_center_description,
		p_material_id,
		p_material_description,	
		p_issue_date,
		p_expiration_date,
		p_currency_id,		
		p_fiscal_year,
		p_document_class,
        p_position_sap,
        p_segment,
		p_register_user_id,
		p_register_user_fullname,
		CURRENT_TIMESTAMP);	 	 
END;
//
DROP procedure IF EXISTS `document_search`;
//
DELIMITER //
CREATE PROCEDURE document_search(
p_company_id varchar(11), 
p_ruc varchar(11))
BEGIN
   SELECT company_id AS companyId,
		ruc AS ruc,
		document_id AS documentId,
		document_reference AS documentReference,
		logistic_center_id AS logisticCenterId,
		logistic_center_description AS logisticCenterDescription,
		material_id AS materialId,
		material_description AS materialDescription,		
		issue_date AS issueDate,
		expiration_date AS expirationDate,
		currency_id AS currencyId,		
		fiscal_year AS fiscalYear,
		document_class AS documentClass,
        position_sap AS positionSap,
        segment AS segment
   FROM document   
   WHERE company_id = p_company_id AND ruc = p_ruc;
END;
//