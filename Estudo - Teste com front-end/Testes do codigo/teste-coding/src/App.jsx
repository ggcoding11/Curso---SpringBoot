import React, { useState, useEffect } from "react";
import { listAllProducts } from "./services/ProductService";

const App = () => {
  const [products, setProducts] = useState(null);

  useEffect(() => {
    listAllProducts()
      .then((response) => {
        console.log(response.data);
        setProducts(response.data);
      })
      .catch((error) => console.log(error));
  }, []);

  return (
    <div className="container-fluid">
      <h1 className="text-center">Lista de produtos</h1>

      {products &&
        products.map((product) => (
          <ul key={product.id}>
            <li>{product.id}</li>
            <li>{product.nome}</li>
            <li>{product.preco}</li>
            <li>{product.quantidade}</li>
          </ul>
        ))}
    </div>
  );
};

export default App;
