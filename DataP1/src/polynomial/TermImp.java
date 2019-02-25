package polynomial;

public class TermImp implements Term {
	
	public int exponent;
	public int coefficient;
	
	
	public TermImp( int e, int c) {
		
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
