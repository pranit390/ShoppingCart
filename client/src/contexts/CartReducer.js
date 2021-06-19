




export const CartReducer = (state, action) => {
    switch (action.type) {
        
        
        
       
        case "CHECKOUT":
            return {
                cartItems: [],
                checkout: true,
                
            }
        case "CLEAR":
                return {
                    cartItems: [],
                   
                }
        default:
            return state

    }
}