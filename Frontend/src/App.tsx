import { useState, useEffect } from "react";
import ConfigurationForm from "./components/ConfigurationForm";
import TicketStatus from "./components/TicketStatus";
import ControlPanel from "./components/ControlPanel";
import LogDisplay from "./components/LogDisplay";
import "./App.css";

export interface SystemConfig {
  totalTickets: number;
  ticketReleaseRate: number;
  customerRetrievalRate: number;
  maxTicketCapacity: number;
}

function App() {
  const [config, setConfig] = useState<SystemConfig | null>(null);
  const [ticketCount, setTicketCount] = useState(0);
  const [isRunning, setIsRunning] = useState(false);
  const [logs, setLogs] = useState<string[]>([]);

  useEffect(() => {
    if (isRunning) {
      const ws = new WebSocket("ws://localhost:8080");

      ws.onmessage = (event) => {
        const data = JSON.parse(event.data);
        if (data.type === "ticketUpdate") {
          setTicketCount(data.count);
        } else if (data.type === "log") {
          setLogs((prevLogs) => [...prevLogs, data.message]);
        }
      };

      return () => {
        ws.close();
      };
    }
  }, [isRunning]);

  const handleStart = () => {
    if (config) {
      setIsRunning(true);
      // Here you would send the configuration to the backend
      console.log("Starting system with config:", config);
    }
  };

  const handleStop = () => {
    setIsRunning(false);
    // Here you would send a stop signal to the backend
    console.log("Stopping system");
  };

  const handleReset = () => {
    setIsRunning(false);
    setTicketCount(0);
    setLogs([]);
    setConfig(null);
    // Here you would send a reset signal to the backend
    console.log("Resetting system");
  };

  return (
    <div className="app">
      <h1>Real-Time Event Ticketing System</h1>
      {!config ? (
        <ConfigurationForm onSubmit={setConfig} />
      ) : (
        <>
          <TicketStatus count={ticketCount} total={config.totalTickets} />
          <ControlPanel
            isRunning={isRunning}
            onStart={handleStart}
            onStop={handleStop}
            onReset={handleReset}
          />
          <LogDisplay logs={logs} />
        </>
      )}
    </div>
  );
}

export default App;
