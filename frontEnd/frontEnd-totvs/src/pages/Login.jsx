import {useNavigate} from 'react-router-dom';

export default function Login() {

    let email;
    let senha;
    const navigate = useNavigate();
    
    function enviar(e) {
        e.preventDefault();

        email = e.target.email.value;
        senha = e.target.senha.value;

        console.log("email:", email);
        console.log("senha:", senha);

        if (email == "vitorpallis@gmail.com" && senha == "123456") {
            navigate("/home", {
            state: {
                email: email
                }
            });
        }
    }


  return (
    <div id="login">

        <div id="box">
            <div >
            <h1>
            Bem vindo
            </h1>
            <p className="text-center text-gray-500 mb-8">
            Entre na sua conta
            </p>
            <form
            id="form" onSubmit={enviar} >
            <div className="mb-4">
                <label className="text-sm text-gray-600">
                Email: 
                </label>
                <input
                id="email"
                type="email"
                placeholder="seuEmail@gmail.com"
                className="mt-1 px-4 py-3 border rounded-xl"
                />
            </div>
            <div className="mb-6">
                <label className="text-sm text-gray-600">
                Senha:
                </label>
                <input
                id="senha"
                type="password"
                placeholder="********"
                className="mt-1 px-4 py-3 border rounded-xl outline-none focus:ring-2 focus:ring-indigo-500"
                />
            </div>
            <button 
            id="entrar"
            className="w-48 bg-indigo-600 text-white py-3 rounded-xl font-semibold hover:bg-indigo-700">
                Entrar
            </button>
            </form>
        </div>
        </div>
    
    </div>
  );
}