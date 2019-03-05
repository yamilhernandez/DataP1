package polynomial;

public class TermImp implements Term {
	
	public int exponent;
	public double coefficient;
	
	
	public TermImp(double coeff, int expo) {
		
		this.exponent=expo;
		this.coefficient=coeff;
		
	}
	@Override
	public double getCoefficient() {
		return coefficient;
	}

	@Override
	public int getExponent() {
		
		return exponent;
	}
	public void setExponent(int exponent) {
		this.exponent = exponent;
	}
	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}
	@Override
	public double evaluate(double x) {
		return (this.coefficient) * (Math.pow(x, this.exponent));
	}
	
	
	

}
