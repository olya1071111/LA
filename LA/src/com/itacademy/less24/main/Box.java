package com.itacademy.less24.main;

import java.util.Objects;

public class Box<T> {
	private T ob1;

	public T getOb1() {
		return ob1;
	}

	public void setOb1(T ob1) {
		this.ob1 = ob1;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ob1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Box other = (Box) obj;
		return Objects.equals(ob1, other.ob1);
	}

	
}
