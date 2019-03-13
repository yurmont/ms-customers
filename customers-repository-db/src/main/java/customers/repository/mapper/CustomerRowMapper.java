package customers.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import customers.domain.Customer;

public class CustomerRowMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {

		Customer document = new Customer();
		document.setCompanyId(rs.getString("companyId"));
		document.setRuc(rs.getString("ruc"));
		document.setDocumentId(rs.getString("documentId"));
		document.setDocumentReference(rs.getString("documentReference"));
		document.setLogisticCenterId(rs.getString("logisticCenterId"));
		document.setLogisticCenterDescription(rs.getString("logisticCenterDescription"));
		document.setMaterialId(rs.getString("materialId"));
		document.setMaterialDescription(rs.getString("materialDescription"));
		document.setIssueDate(rs.getDate("issueDate"));
		document.setExpirationDate(rs.getDate("expirationDate"));
		document.setCurrencyId(rs.getString("currencyId"));
		document.setFiscalYear(rs.getInt("fiscalYear"));
		document.setDocumentClass(rs.getString("documentClass"));
		document.setPositionSap(rs.getString("positionSap"));
		document.setSegment(rs.getString("segment"));

		return document;
	}
}
