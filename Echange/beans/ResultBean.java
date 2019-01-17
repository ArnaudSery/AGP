package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ResultBean {

	@ManagedProperty(value = "#entryBean")
	private EntryBean entryBean;
}
