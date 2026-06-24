export default function Header() {

    return(
        <div id="header" className="bg-[#1B1C28] border border-white">
            <header className="grid grid-cols-3">
                <div className="grid grid-cols-[100px_2fr] gap-2 ml-4">
                    <img className="max-w-[100%]" src="/public/logoTotvs.webp"></img>
                    <h1 className="mt-5 text-6xl text-white font-bold">TOTVS</h1>
                </div>
                <div>
                    <h1 classname="text-6xl text-white font-bold">nexus</h1>
                </div>
                <div></div>
            </header>
        </div>
    )
}