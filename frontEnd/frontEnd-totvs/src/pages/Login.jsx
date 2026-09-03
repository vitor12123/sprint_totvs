import {useNavigate} from 'react-router-dom';
import ErrorAlert from '../components/login/ErroAlert';

export default function Login() {

    let email;
    let senha;
    const navigate = useNavigate();
    
    async function enviar(e) {
        e.preventDefault();

        const pergunta = await fetch(`${import.meta.env.VITE_BACKEND_URL}/login`, {
            method: "POST",
            headers: {"content-type": "application/json"},
            body: JSON.stringify({
                email: e.target.email.value,
                senha: e.target.senha.value
            })
        });

        const resposta = await pergunta.text();

        if (resposta == "true") {
            navigate("/home");
        }
        else if (resposta == "false") {
            document.getElementById("mensagem_erro").style.opacity = 1;
        }

    }

  return (
    <div id="login" className="flex flex-col">

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

        
        <div id="mensagem_erro" className="text-center opacity-0">
            <ErrorAlert />
        </div>
        
    
    </div>
  );
}