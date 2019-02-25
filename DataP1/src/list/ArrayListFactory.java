package list;

public class ArrayListFactory<E> implements ListFactory<E> {

	@Override
	public List<E> newInstance() {
		return new ArrayList<E>();
	}

}
