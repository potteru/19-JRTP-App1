package in.ashokit.services;

import org.springframework.stereotype.Service;

import in.ashokit.bindings.UnlockAccRequest;

@Service
public interface UnlockAccountService {
	
	public String unlockAccount(UnlockAccRequest request); 
	

}
