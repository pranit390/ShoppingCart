import React, { createContext, useReducer, useEffect, useState } from 'react';
import { CartReducer, sumItems } from './CartReducer';

export const CartContext = createContext()




const initialState = {};

const CartContextProvider = ({ children }) => {





	const [state, dispatch] = useReducer(CartReducer, initialState)



	const clearCart = () => {
		dispatch({ type: 'CLEAR' })
	}

	const handleCheckout = () => {
		console.log('CHECKOUT', state);
		dispatch({ type: 'CHECKOUT' })
	}

	const contextValues = {

		clearCart,
		handleCheckout,
		...state
	}

	return (
		<CartContext.Provider value={contextValues} >
			{ children}
		</CartContext.Provider>
	);
}

export default CartContextProvider;
