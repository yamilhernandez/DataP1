package polynomial;

import java.text.DecimalFormat;
import java.util.Iterator;

import list.List;
import list.ListFactory;

public class PolynomialImp implements Polynomial, Comparable{
	
	public List<Term> list;
	private ListFactory<Term> factory= TermListFactory.newListFactory();
	private Iterator<Term> iter;
	
	
	
	
	
	public PolynomialImp(String poly) {
		this.list= factory.newInstance();
		createTerms(poly);
		
		
		
		
	}

	@Override
	public Iterator<Term> iterator() {
		//iter= new Iterator<Term>();

		return iter;
	}

	@Override
	public Polynomial add(Polynomial P2) {
		PolynomialImp p1= new PolynomialImp(this.toString());
		PolynomialImp p2= (PolynomialImp) P2;
		for (int i = 0; i < p2.list.size(); i++) {
			boolean added=false;
			for (int j = 0; j < p1.list.size(); j++) {
				if(p2.list.get(i).getExponent()==p1.list.get(j).getExponent()) {
					int expo= p1.list.get(j).getExponent();
					double newCoeff = p1.list.get(j).getCoefficient() +p2.list.get(i).getCoefficient();
					p1.list.set(j, new TermImp(newCoeff, expo));
					added=true;
					break;
				}
			}
			if(added==false) {
				p1.list.add(p2.list.get(i));
			}
			
		}
		p1.organize();
		return p1;
	}

	@Override
	public Polynomial subtract(Polynomial P2) {
		PolynomialImp p1= new PolynomialImp(this.toString());
		PolynomialImp p2= (PolynomialImp) P2;
	/*	for (int i = 0; i < p2.list.size(); i++) {
			boolean added=false;
			for (int j = 0; j < this.list.size(); j++) {
				if(p2.list.get(i).getExponent()==this.list.get(j).getExponent()) {
					int expo= this.list.get(j).getExponent();
					double newCoeff = this.list.get(j).getCoefficient() +(-1)*p2.list.get(i).getCoefficient();
					this.list.set(j, new TermImp(newCoeff, expo));
					added=true;
					break;
				}
			}
			if(added==false) {
				this.list.add(new TermImp(p2.list.get(i).getCoefficient()*(-1), p2.list.get(i).getExponent()));
			}
		}
		return this;*/
		
		return p1.add(p2.multiply(-1));
	}

	@Override
	public Polynomial multiply(Polynomial P2) {
		PolynomialImp result= new PolynomialImp("");
		PolynomialImp p1= new PolynomialImp(this.toString());
		PolynomialImp p2= (PolynomialImp) P2;
		for (int i = 0; i < p2.list.size(); i++) {
			PolynomialImp result1= new PolynomialImp("");
			for (int j = 0; j < p1.list.size(); j++) {
				int newExpo= p2.list.get(i).getExponent()+ p1.list.get(j).getExponent();
				double newCoeff= p2.list.get(i).getCoefficient()* p1.list.get(j).getCoefficient();
				result1.list.add(new TermImp( newCoeff,newExpo));
			}
			result=(PolynomialImp) result.add(result1);
			
			
		}
		for (int i = 0; i < result.list.size(); i++) {
			System.out.println("Coeff=" + result.list.get(i).getCoefficient());
			System.out.println("Expo=" + result.list.get(i).getExponent());
		}
		return result;
	}

	@Override
	public Polynomial multiply(double c) {
		PolynomialImp p1= new PolynomialImp(this.toString());
		for (int i = 0; i < p1.list.size(); i++) {
			double newCoeff= c* p1.list.get(i).getCoefficient();
			p1.list.set(i, new TermImp(newCoeff, p1.list.get(i).getExponent()));
			
		}
		p1.organize();
		return p1;
	}

	@Override
	public Polynomial derivative() {
		PolynomialImp p1= new PolynomialImp(this.toString());
		
		for (int i = 0; i < p1.list.size(); i++) {
			if(p1.list.get(i).getExponent()==0) {
				p1.list.remove(i);
				break;
			}
			double newCoeff= p1.list.get(i).getExponent()* p1.list.get(i).getCoefficient();
			int newExpo= p1.list.get(i).getExponent()-1;
			p1.list.set(i, new TermImp(newCoeff, newExpo));
			
		}
		return p1;
	}

	@Override
	public Polynomial indefiniteIntegral() {
		PolynomialImp result= new PolynomialImp("");
		
		for (int i = 0; i < this.list.size(); i++) {
			result.list.add(new TermImp(list.get(i).getCoefficient()/(list.get(i).getExponent()+1),list.get(i).getExponent()+1));
		}
		result.list.add(new TermImp(1.00,0));
		return result;
	}

	@Override
	public double definiteIntegral(double a, double b) {
		PolynomialImp poly= (PolynomialImp) this.indefiniteIntegral();
		double result1=poly.evaluate(b)- poly.evaluate(a);
		return result1;
	}

	@Override
	public int degree() {
		int degree=this.list.get(0).getExponent();
		for (int i = 0; i < this.list.size(); i++) {
			if(this.list.get(i).getExponent()>degree) {
				degree=this.list.get(i).getExponent();
			}
			
		}
		return degree;
	}

	@Override
	public double evaluate(double x) {
		double result=0;
		for (int i = 0; i < this.list.size(); i++) {
			//double coef= this.list.get(i).getCoefficient();
			//int expo= this.list.get(i).getExponent();
			result+= this.list.get(i).evaluate(x);
		}
		return result;
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
	public void organize() {
		for (int i = 0; i < this.list.size(); i++) {
			if(this.list.get(i).getCoefficient()==0) {
				list.remove(i);
			}
			
		}
		for (int i = 0; i < list.size(); i++) {
			if(this.list.get(i).getCoefficient()==0) {
				list.set(i,new TermImp(0,0));
			}
		}
		
		
	}
	
	public String toString() {
		String result ="";
		DecimalFormat df = new DecimalFormat("####0.00");
		for (int i = 0; i < list.size(); i++) {
			if(this.list.get(i).getExponent()>1) {
				
				String coeff= df.format(this.list.get(i).getCoefficient());
				String expo= Integer.toString(this.list.get(i).getExponent());
				result+= coeff+"x^"+ expo+ '+';
			}
			if(this.list.get(i).getExponent()==1) {
				String coeff= df.format(this.list.get(i).getCoefficient());
				
				result+= coeff+"x+";
			}
			if(this.list.get(i).getExponent()==0) {
				String coeff= df.format(this.list.get(i).getCoefficient());
				
				result+= coeff;
			}
		}
		return result;
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
						if(!terms[i].startsWith("x")){
							coeff= Double.parseDouble(terms[i].substring(0, j-1));
						}
						else {coeff= 1;}
						this.list.add(new TermImp(coeff,expo));
						
					}
				}
				else if(terms[i].contains("x")) {
					if(terms[i].charAt(j)== 'x') {
						expo=1;
						if(!terms[i].startsWith("x")){
							coeff=Double.parseDouble(terms[i].substring(0, j));
						}
						else {
							coeff= 1;
						}
						
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

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}
