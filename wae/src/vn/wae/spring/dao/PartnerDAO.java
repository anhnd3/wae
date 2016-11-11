package vn.wae.spring.dao;

import java.util.List;

import vn.wae.spring.entity.Partner;

public interface PartnerDAO {

	public int savePartner(Partner partner);

	public int deletePartner(int partnerId);

	public Partner getPartner(int partnerId);

	public List<Partner> getPartners(int pos, int limit);
	
	public List<Partner> getPartnersAvailable(int pos, int limit);

}
