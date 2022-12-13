package champollion;

public class ServicePrevu {
    
        private UE ue;
	private final Enseignant enseignants;

	private int CM;
	private int TD;
	private int TP;

	public ServicePrevu(Enseignant enseignants, UE ue, int CM, int TD, int TP){
		this.enseignants=enseignants;
		this.ue=ue;
		this.CM=CM;
		this.TD=TD;
		this.TP=TP;
	}

    public UE getUE() {
        return ue;
    }

    public void setUE(UE ue) {
        this.ue = ue;
    }

    public int getCM() {
        return CM;
    }

    public void setCM(int CM) {
        this.CM = CM;
    }

    public int getTD() {
        return TD;
    }

    public void setTD(int TD) {
        this.TD = TD;
    }

    public int getTP() {
        return TP;
    }

    public void setTP(int TP) {
        this.TP = TP;
    }

}

	