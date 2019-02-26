package polynomial;

import java.util.Iterator;

import list.List;
import list.ListFactory;

public class PolynomialImp implements Polynomial{
	
	public List<Term> list;
	private ListFactory<Term> factory= TermListFactory.newListFactory();
	private Iterator<Term> iter;
	
	
	
	
	
	public PolynomialImp(String poly) {
		this.list= factory.newInstance();
		createTerms(poly);
	/*	for (int i = 0; i < list.size(); i++) {
			System.out.println("Coeff=" + list.get(i).getCoefficient());
			System.out.println("Expo=" + list.get(i).getExponent());
		}*/
		
		
		
	}

	@Override
	public Iterator<Term> iterator() {
		//iter= new Iterator<Term>();

		return iter;
	}

	@Override
	public Polynomial add(Polynomial P2) {
		PolynomialImp p2= (PolynomialImp) P2;
		for (int i = 0; i < this.list.size(); i++) {
			for (int j = i; j <p2.list.size(); j++) {
				if(this.list.get(i).getExponent()==p2.list.get(j).getExponent()) {
					double newCoeff = this.list.get(i).getCoefficient() + p2.list.get(j).getCoefficient();
					this.list.set(i, new TermImp(newCoeff, this.list.get(i).getExponent()));
				}
			}
		
		}
		return this;
	}

	@Override
	public Polynomial subtract(Polynomial P2) {
		PolynomialImp p2= (PolynomialImp) P2;
		for (int i = 0; i < this.list.size(); i++) {
			for (int j = i; j <p2.list.size(); j++) {
				if(this.list.get(i).getExponent()==p2.list.get(j).getExponent()) {
					double newCoeff = this.list.get(i).getCoefficient() + (-1) *p2.list.get(j).getCoefficient();
					this.list.set(i, new TermImp(newCoeff, this.list.get(i).getExponent()));
				}
			}
		
		}
		return this;
	}

	@Override
	public Polynomial multiply(Polynomial P2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Polynomial multiply(double c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Polynomial derivative() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Polynomial indefiniteIntegral() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double definiteIntegral(double a, double b) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int degree() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double evaluate(double x) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean equals(Polynomial P) {
		PolynomialImp p= (PolynomialImp) P;
		
		for (int i = 0; i < this.list.size(); i++) {
			int expToCheck= this.list.get(i).getExponent();
			for (int j = 0; j < p.list.size(); j++) {
				if(p.list.get(j).getExponent()== expToCheck) {
					if(this.list.get(i).getCoefficient()!= p.list.get(j).getCoefficient()) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	private void createTerms(String poly) {
		String [] terms=poly.split("\\+");
		for (int i = 0; i < terms.length; i++) {
			int expo;
			double coeff;
			for (int j = 0; j < terms[i].length(); j++) {
				if(terms[i].contains("^")) {
					if(terms[i].charAt(j)== '^') {
						expo= Integer.parseInt(terms[i].substring(j+1));
						coeff= Double.parseDouble(terms[i].substring(0, j-1));
						this.list.add(new TermImp(coeff,expo));
					}
				}
				else if(terms[i].contains("x")) {
					if(terms[i].charAt(j)== 'x') {
						expo=1;
						coeff=Double.parseDouble(terms[i].substring(0, j));
						this.list.add(new TermImp(coeff,expo));
					}
				}
				else {
					expo=0;
					coeff=Double.parseDouble(terms[i]);
					this.list.add(new TermImp(coeff,expo));
					return;
				}
			}
		}
	}
}
