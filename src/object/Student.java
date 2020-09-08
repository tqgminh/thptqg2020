package object;

public class Student {
	
	private String identification;
	private double math;
	private double literature;
	private double physics;
	private double chemistry;
	private double biology;
	private double history;
	private double geography;
	private double physicalEducation;
	private double foreignerLanguage;
	private String codeForeignerLanguage;
	private double A00;
	private double A01;
	private double B00;
	private double C00;
	private double D01;
	
	public Student(String soBaoDanh, double diemToan, double diemVan, double diemLy, double diemHoa, double diemSinh, double diemSu, double diemDia, double diemGDCD, double diemNN, String maNN) {
		super();
		this.identification = soBaoDanh;
		this.math = diemToan;
		this.literature = diemVan;
		this.physics = diemLy;
		this.chemistry = diemHoa;
		this.biology = diemSinh;
		this.history= diemSu;
		this.geography = diemDia;
		this.physicalEducation = diemGDCD;
		this.foreignerLanguage = diemNN;
		this.codeForeignerLanguage = maNN;
		this.A00 = diemToan+diemLy+diemHoa;
		if(maNN.compareTo("N1") == 0)
			this.A01 = (double) Math.round((diemToan+diemLy+diemNN)*100)/100;
		else
			this.A01 = (double) Math.round((diemToan+diemLy)*100)/100;
		this.B00 = (double) Math.round((diemToan+diemHoa+diemSinh)*100)/100;
		this.C00 = (double) Math.round((diemVan+diemSu+diemDia)*100)/100;
		if(maNN.compareTo("N1") == 0)
			this.D01 = (double) Math.round((diemToan+diemVan+diemNN)*100)/100;
		else
			this.D01 = (double) Math.round((diemToan+diemVan)*100)/100;
	}
	
	public Student(String soBaoDanh) {
		super();
		this.identification = soBaoDanh;
	}
	
	
	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public double getMath() {
		return math;
	}

	public void setMath(double math) {
		this.math = math;
	}

	public double getLiterature() {
		return literature;
	}

	public void setLiterature(double literature) {
		this.literature = literature;
	}

	public double getPhysics() {
		return physics;
	}

	public void setPhysics(double physics) {
		this.physics = physics;
	}

	public double getChemistry() {
		return chemistry;
	}

	public void setChemistry(double chemistry) {
		this.chemistry = chemistry;
	}

	public double getBiology() {
		return biology;
	}

	public void setBiology(double biology) {
		this.biology = biology;
	}

	public double getHistory() {
		return history;
	}

	public void setHistory(double history) {
		this.history = history;
	}

	public double getGeography() {
		return geography;
	}

	public void setGeography(double geography) {
		this.geography = geography;
	}

	public double getPhysicalEducation() {
		return physicalEducation;
	}

	public void setPhysicalEducation(double physicalEducation) {
		this.physicalEducation = physicalEducation;
	}

	public double getForeignerLanguage() {
		return foreignerLanguage;
	}

	public void setForeignerLanguage(double foreignerLanguage) {
		this.foreignerLanguage = foreignerLanguage;
	}

	public String getCodeForeignerLanguage() {
		return codeForeignerLanguage;
	}

	public void setCodeforeignerLanguage(String codeforeignerLanguage) {
		this.codeForeignerLanguage = codeforeignerLanguage;
	}

	public double getA00() {
		return A00;
	}

	public void setA00(double a00) {
		A00 = a00;
	}

	public double getA01() {
		return A01;
	}

	public void setA01(double a01) {
		A01 = a01;
	}

	public double getB00() {
		return B00;
	}

	public void setB00(double b00) {
		B00 = b00;
	}

	public double getC00() {
		return C00;
	}

	public void setC00(double c00) {
		C00 = c00;
	}

	public double getD01() {
		return D01;
	}

	public void setD01(double d01) {
		D01 = d01;
	}

	public void setCodeForeignerLanguage(String codeForeignerLanguage) {
		this.codeForeignerLanguage = codeForeignerLanguage;
	}
	
}
