package logic;

import java.util.ArrayList;

public class AbstractLogic {
	public AbstractLogic() {
		this._errs = new ArrayList<String>();
	}
	protected ArrayList<String> _errs=null;

	public boolean hasErrors(){
		return !this._errs.isEmpty();
	}

	public void setError(String msg){
		this._errs.add(msg);
	}

	public ArrayList<String> getErrors(){
		return this._errs;
	}
}
