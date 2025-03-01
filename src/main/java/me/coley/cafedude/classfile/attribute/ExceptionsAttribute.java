package me.coley.cafedude.classfile.attribute;

import java.util.List;
import java.util.Set;

/**
 * Checked exceptions attribute.
 *
 * @author JCWasmx86
 */
public class ExceptionsAttribute extends Attribute {
	private List<Integer> exceptionIndexTable;

	/**
	 * @param nameIndex
	 * 		Name index in constant pool.
	 * @param exceptionIndexTable
	 * 		Indices into the constant pool representing all checked exceptions
	 * 		that may be thrown by this method.
	 */
	public ExceptionsAttribute(int nameIndex, List<Integer> exceptionIndexTable) {
		super(nameIndex);
		this.exceptionIndexTable = exceptionIndexTable;
	}

	/**
	 * @return Exception index table.
	 */
	public List<Integer> getExceptionIndexTable() {
		return exceptionIndexTable;
	}

	/**
	 * @param exceptionIndexTable
	 * 		Indices into the constant pool representing all checked exceptions
	 * 		that may be thrown by this method.
	 */
	public void setExceptionIndexTable(List<Integer> exceptionIndexTable) {
		this.exceptionIndexTable = exceptionIndexTable;
	}

	@Override
	public Set<Integer> cpAccesses() {
		Set<Integer> set = super.cpAccesses();
		set.addAll(getExceptionIndexTable());
		return set;
	}

	@Override
	public int computeInternalLength() {
		// Multiplying with two, as each index has two bytes.
		return 2 + exceptionIndexTable.size() * 2;
	}
}
