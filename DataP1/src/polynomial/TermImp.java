package polynomial;

public class TermImp implements Term {
	
	public int exponent;
	public double coefficient;
	
	
	public TermImp( int e, double c) {
		
		this.exponent=e;
		this.coefficient=c;
		
	}
	@Override
	public double getCoefficient() {
		
		return this.coefficient;
	}

	@Override
	public int getExponent() {
		
		return this.exponent;
	}

	@Override
	public double evaluate(double x) {
		return (this.coefficient) * (Math.pow(x, this.exponent));
	}

}
